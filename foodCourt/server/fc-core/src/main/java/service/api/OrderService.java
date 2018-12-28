package service.api;

import domain.Order;
import exception.FCException;

public interface OrderService {
    Order save(Order order) throws FCException;
    Order findById(Long orderId) throws FCException;
}
