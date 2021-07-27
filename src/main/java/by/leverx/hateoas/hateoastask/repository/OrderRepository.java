package by.leverx.hateoas.hateoastask.repository;

import by.leverx.hateoas.hateoastask.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Valeryia Zubrytskaya
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
