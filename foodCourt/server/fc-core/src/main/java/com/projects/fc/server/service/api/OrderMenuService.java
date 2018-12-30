package com.projects.fc.server.service.api;

import com.projects.fc.server.core.domain.MenuItem;
import com.projects.fc.server.core.domain.Order;
import com.projects.fc.server.core.domain.OrderMenu;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.request.OrderRequest;

import java.util.List;

public interface OrderMenuService {

    OrderMenu save(OrderMenu orderMenu) throws FCException;
    Iterable<OrderMenu> save(OrderRequest createOrderRequest, Order order, List<MenuItem> menuItemList) throws FCException;
    Iterable<OrderMenu> save(Iterable<OrderMenu> orderMenu) throws FCException;
    OrderMenu findById(Long orderMenuId) throws FCException;
}
