package com.projects.fc.server.service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.request.MenuItemRequest;

public interface MenuItemManagerService {
    ClientResponse addMenuItem(MenuItemRequest menuItemRequest, String requestedBy,
                               String requestId) throws FCException;
}
