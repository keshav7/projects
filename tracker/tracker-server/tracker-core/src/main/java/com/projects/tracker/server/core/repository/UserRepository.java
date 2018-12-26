package com.projects.tracker.server.core.repository;

import com.projects.tracker.server.core.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}