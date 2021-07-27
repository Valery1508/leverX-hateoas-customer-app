package by.leverx.hateoas.hateoastask.repository;

import by.leverx.hateoas.hateoastask.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Valeryia Zubrytskaya
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
