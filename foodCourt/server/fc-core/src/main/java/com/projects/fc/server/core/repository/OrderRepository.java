package com.projects.fc.server.core.repository;

import com.projects.fc.server.core.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>{
}
