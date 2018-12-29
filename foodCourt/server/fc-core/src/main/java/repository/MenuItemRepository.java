package repository;

import domain.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
