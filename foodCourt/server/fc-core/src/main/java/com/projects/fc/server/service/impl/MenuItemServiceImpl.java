package com.projects.fc.server.service.impl;

import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.domain.MenuItem;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.projects.fc.server.core.repository.MenuItemRepository;
import com.projects.fc.server.core.request.MenuItemRequest;
import com.projects.fc.server.service.api.MenuItemService;

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
