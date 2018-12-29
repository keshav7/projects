package service.impl;

import domain.Order;
import enums.Errors;
import enums.OrderStatus;
import exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.OrderRepository;
import request.OrderRequest;
import service.api.OrderService;

@Slf4j
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(OrderRequest orderRequest) throws FCException {
        try {
            Order order = setDomainAttributes(orderRequest);
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    private Order setDomainAttributes(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setCustomerPhone(orderRequest.getCustomerPhone());
        return order;
    }

    @Override
    public Order findById(Long orderId) throws FCException {
        try {
            return orderRepository.findOne(orderId);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}