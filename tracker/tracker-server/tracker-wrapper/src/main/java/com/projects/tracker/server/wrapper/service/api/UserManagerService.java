package com.projects.tracker.server.wrapper.service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import com.projects.tracker.server.core.TrackerException;
import com.projects.tracker.server.core.request.CreateUserRequest;

public interface UserManagerService {
    ClientResponse addUser(CreateUserRequest createUserRequest) throws TrackerException;
}