package com.projects.fc.server.service.impl;

import com.projects.fc.server.core.domain.Order;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.enums.OrderStatus;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projects.fc.server.core.repository.OrderRepository;
import com.projects.fc.server.core.request.OrderRequest;
import com.projects.fc.server.service.api.OrderService;

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