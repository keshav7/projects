package com.projects.fc.server.core.repository;

import com.projects.fc.server.core.domain.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
