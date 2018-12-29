package service.impl;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import domain.Company;
import domain.MenuItem;
import enums.Errors;
import exception.FCException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import request.MenuItemRequest;
import service.api.CompanyService;
import service.api.MenuItemManagerService;
import service.api.MenuItemService;

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
