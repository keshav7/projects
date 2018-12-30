package com.projects.fc.server.service.impl;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.fc.server.core.domain.Company;
import com.projects.fc.server.core.enums.Errors;
import com.projects.fc.server.core.exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.projects.fc.server.core.request.MenuItemRequest;
import com.projects.fc.server.service.api.CompanyService;
import com.projects.fc.server.service.api.MenuItemManagerService;
import com.projects.fc.server.service.api.MenuItemService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class menuItemManagerServiceImpl implements MenuItemManagerService{

    @Autowired
    MenuItemService menuItemService;
    @Autowired
    CompanyService companyService;

    @Override
    public ClientResponse addMenuItem(MenuItemRequest menuItemRequest, String requestedBy, String requestId)
            throws FCException {
        try {
            ClientResponse clientResponse = null;
            Company company = companyService.findById(Long.parseLong(menuItemRequest.getCompanyId()));
            menuItemService.save(menuItemRequest, company);
            Map<String, Object> responseData = new HashMap();
            clientResponse = new ClientResponse(SuccessCodes.CREATED, HttpStatus.CREATED, responseData);
            return clientResponse;
        } catch(FCException e) {
            throw e;
        } catch(Exception e) {
            throw new FCException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }
}
