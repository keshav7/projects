package service.impl;

import domain.Company;
import domain.MenuItem;
import enums.Errors;
import exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.MenuItemRepository;
import request.MenuItemRequest;
import service.api.MenuItemService;

@Slf4j
@Component
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;


    @Override
    public MenuItem save(MenuItemRequest request, Company company) throws FCException {
        try {
            return menuItemRepository.save(setDomainAttributes(request, company));
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }


    private MenuItem setDomainAttributes(MenuItemRequest request, Company company) {
        return MenuItem.builder().
                menuType(request.getMenuType()).
                name(request.getName()).
                price(request.getPrice()).
                company(company).build();
    }

    @Override
    public MenuItem findById(Long menuItemId) throws FCException {
        try {
            return menuItemRepository.findOne(menuItemId);
        } catch (Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
