package by.leverx.hateoas.hateoastask.repository;

import by.leverx.hateoas.hateoastask.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Valeryia Zubrytskaya
 */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
