package service.api;

import domain.MenuItem;
import domain.OrderMenu;
import exception.FCException;

public interface MenuItemService {

    MenuItem save(MenuItem menuItem) throws FCException;
    MenuItem findById(Long menuItemId) throws FCException;
}
