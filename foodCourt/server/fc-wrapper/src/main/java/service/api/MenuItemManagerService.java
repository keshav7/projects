package service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import domain.Company;
import domain.MenuItem;
import exception.FCException;
import request.MenuItemRequest;

public interface MenuItemManagerService {
    ClientResponse addMenuItem(MenuItemRequest menuItemRequest, String requestedBy,
                               String requestId) throws FCException;
}
