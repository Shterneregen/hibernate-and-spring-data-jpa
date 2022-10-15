package random.jpaorderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaorderservice.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
