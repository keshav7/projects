package com.projects.fc.server.service.impl;

import com.projects.fc.server.core.domain.MenuItem;
import com.projects.fc.server.core.domain.Order;
import com.projects.fc.server.core.domain.OrderMenu;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projects.fc.server.core.repository.OrderMenuRepository;
import com.projects.fc.server.core.request.OrderRequest;
import com.projects.fc.server.service.api.OrderMenuService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class OrderMenuServiceImpl implements OrderMenuService{

    @Autowired
    OrderMenuRepository orderMenuRepository;

    @Override
    public OrderMenu save(OrderMenu orderMenu) throws FCException {
        try {
            return orderMenuRepository.save(orderMenu);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public Iterable<OrderMenu> save(OrderRequest createOrderRequest, Order order, List<MenuItem> menuItemList)
            throws FCException {
        try {
            List<OrderMenu> orderMenuList = new ArrayList<>();
            for(MenuItem menuItem: menuItemList) {
                OrderMenu orderMenu = new OrderMenu();
                orderMenu.setOrder1(order);
                orderMenu.setMenuItem(menuItem);
                orderMenu.setQuantity(createOrderRequest.getMenuItemQty().get(menuItem.getId()));
                orderMenuList.add(orderMenu);
            }
            return orderMenuRepository.save(orderMenuList);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }



    @Override
    public Iterable<OrderMenu> save(Iterable<OrderMenu> orderMenus) throws FCException {
        try {
            return orderMenuRepository.save(orderMenus);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    @Override
    public OrderMenu findById(Long orderMenuId) throws FCException {
        try {
            return orderMenuRepository.findOne(orderMenuId);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}