package random.jpaorderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaorderservice.domain.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByDescription(String description);
}
