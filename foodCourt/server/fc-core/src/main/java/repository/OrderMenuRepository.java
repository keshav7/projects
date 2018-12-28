package repository;

import domain.OrderMenu;
import org.springframework.data.repository.CrudRepository;

public interface OrderMenuRepository extends CrudRepository<OrderMenu, Long> {
}
