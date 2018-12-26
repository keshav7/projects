package com.projects.tracker.server.wrapper.service.impl;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.core.utils.SuccessCodes;
import com.projects.tracker.server.core.TrackerException;
import com.projects.tracker.server.core.enums.Errors;
import com.projects.tracker.server.core.request.CreateUserRequest;
import com.projects.tracker.server.core.service.api.UserService;
import com.projects.tracker.server.wrapper.service.api.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserManagerServiceImpl implements UserManagerService{

    @Autowired
    private UserService userService;
    @Override
    public ClientResponse addUser(CreateUserRequest createUserRequest) throws TrackerException{
        try {
            userService.addUser(createUserRequest);
        } catch (TrackerException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new TrackerException(Errors.LMS_INTERNAL_ERROR, exception);
        }
        return new ClientResponse(SuccessCodes.OK);
    }
}
