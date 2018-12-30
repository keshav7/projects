package com.projects.fc.server.service.api;

import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.domain.MenuItem;
import com.projects.fc.server.core.exception.FCException;
import com.projects.fc.server.core.request.MenuItemRequest;

public interface MenuItemService {

    MenuItem save(MenuItemRequest request, Company company) throws FCException;
    MenuItem findById(Long menuItemId) throws FCException;
}
