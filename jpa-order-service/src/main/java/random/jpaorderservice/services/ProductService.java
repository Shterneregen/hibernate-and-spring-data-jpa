package random.jpaorderservice.services;

import random.jpaorderservice.domain.Product;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateQOH(Long id, Integer quantityOnHand);
}
