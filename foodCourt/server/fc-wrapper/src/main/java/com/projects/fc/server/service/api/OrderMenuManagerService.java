package com.projects.fc.server.service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.request.OrderRequest;

public interface OrderMenuManagerService {
    ClientResponse createOrder(OrderRequest createOrderRequest, String requestedBy,
                               String requestId) throws FCException;


}
