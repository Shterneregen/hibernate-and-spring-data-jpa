package random.jpaorderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaorderservice.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByDescription(String description);
}
