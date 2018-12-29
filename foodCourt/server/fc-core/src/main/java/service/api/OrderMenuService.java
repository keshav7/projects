package service.api;

import domain.MenuItem;
import domain.Order;
import domain.OrderMenu;
import exception.FCException;
import request.OrderRequest;

import java.util.List;

public interface OrderMenuService {

    OrderMenu save(OrderMenu orderMenu) throws FCException;
    Iterable<OrderMenu> save(OrderRequest createOrderRequest, Order order, List<MenuItem> menuItemList) throws FCException;
    Iterable<OrderMenu> save(Iterable<OrderMenu> orderMenu) throws FCException;
    OrderMenu findById(Long orderMenuId) throws FCException;
}
