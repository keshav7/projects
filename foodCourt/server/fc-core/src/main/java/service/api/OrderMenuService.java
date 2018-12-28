package service.api;

import domain.Order;
import domain.OrderMenu;
import exception.FCException;

public interface OrderMenuService {

    OrderMenu save(OrderMenu orderMenu) throws FCException;
    OrderMenu findById(Long orderMenuId) throws FCException;
}
