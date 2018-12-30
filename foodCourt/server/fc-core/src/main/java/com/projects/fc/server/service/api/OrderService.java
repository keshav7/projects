package com.projects.fc.server.service.api;

import com.projects.fc.server.core.domain.Order;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.request.OrderRequest;

public interface OrderService {
    Order save(OrderRequest request) throws FCException;
    Order findById(Long orderId) throws FCException;
}
