package service.api;

import domain.Order;
import exception.FCException;
import request.OrderRequest;

public interface OrderService {
    Order save(OrderRequest request) throws FCException;
    Order findById(Long orderId) throws FCException;
}
