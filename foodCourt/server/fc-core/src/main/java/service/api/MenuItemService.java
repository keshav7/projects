package service.api;

import domain.Company;
import domain.MenuItem;
import domain.OrderMenu;
import exception.FCException;
import request.MenuItemRequest;

public interface MenuItemService {

    MenuItem save(MenuItemRequest request, Company company) throws FCException;
    MenuItem findById(Long menuItemId) throws FCException;
}
