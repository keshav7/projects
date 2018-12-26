package com.projects.tracker.server.core.service.impl;

import com.projects.tracker.server.core.TrackerException;
import com.projects.tracker.server.core.domain.User;
import com.projects.tracker.server.core.enums.Errors;
import com.projects.tracker.server.core.enums.Gender;
import com.projects.tracker.server.core.repository.UserRepository;
import com.projects.tracker.server.core.request.CreateUserRequest;
import com.projects.tracker.server.core.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(CreateUserRequest createUserRequest) throws TrackerException {
        try {
            User user = new User();
            setDomainAttributes(createUserRequest, user);
            return userRepository.save(user);
        }
        catch (Exception e) {
            throw new TrackerException(Errors.LMS_INTERNAL_ERROR, e);
        }
    }

    private void setDomainAttributes(CreateUserRequest createUserRequest, User user) {
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setGender(Gender.valueOf(createUserRequest.getGender().toString()));
    }
}
