package random.jpaorderservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import random.jpaorderservice.domain.Product;
import random.jpaorderservice.repositories.ProductRepository;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    // Why did the error occur in the bootstrap service, and not in the Spring Boot test?
    // The Spring Boot Test creates a transaction by default, thus statements run within a transactional context (provided by Spring Boot).
    // Error occurred from running outside of a transaction.
    @Transactional // Delete it and Bootstrap.run will fail during context initialization. But not in test.
    @Override
    public Product updateQOH(Long id, Integer quantityOnHand) {
        Product product = productRepository.findById(id)
                .orElseThrow();

        product.setQuantityOnHand(quantityOnHand);

        return productRepository.saveAndFlush(product);
    }
}
