package com.projects.tracker.server.core.service.api;

import com.projects.tracker.server.core.TrackerException;
import com.projects.tracker.server.core.domain.User;
import com.projects.tracker.server.core.request.CreateUserRequest;

public interface UserService {

    User addUser(CreateUserRequest createUserRequest) throws TrackerException;

}
