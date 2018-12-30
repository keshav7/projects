package com.projects.fc.server.service.impl;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.fc.server.core.domain.MenuItem;
import com.projects.fc.server.core.domain.Order;
import com.projects.fc.server.core.domain.OrderMenu;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.projects.fc.server.core.request.OrderRequest;
import com.projects.fc.server.service.api.MenuItemService;
import com.projects.fc.server.service.api.OrderMenuManagerService;
import com.projects.fc.server.service.api.OrderMenuService;
import com.projects.fc.server.service.api.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class OrderMenuManagerServiceImpl implements OrderMenuManagerService {

    @Autowired
    OrderService orderService;
    @Autowired
    MenuItemService menuItemService;
    @Autowired
    OrderMenuService orderMenuService;


    @Override
    public ClientResponse createOrder(OrderRequest createOrderRequest, String requestedBy,
                                      String requestId) throws FCException {
        try {
            ClientResponse clientResponse = null;
            Order order = orderService.save(createOrderRequest);
            HashMap<String, Integer> orderMenuItemMap = createOrderRequest.getMenuItemQty();
            List<MenuItem> menuItems = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : orderMenuItemMap.entrySet()) {
                String menuItemId = entry.getKey();
                menuItems.add(menuItemService.findById(Long.parseLong(menuItemId)));
            }
            Iterable<OrderMenu> orderMenuList = orderMenuService.save(createOrderRequest, order, menuItems);
            Map<String, Object> responseData = new HashMap();
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
            clientResponse.setData(orderMenuList);
            return clientResponse;
        } catch(FCException e) {
            throw e;
        } catch(Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
