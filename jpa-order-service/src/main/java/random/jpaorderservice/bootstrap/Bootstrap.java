package random.jpaorderservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.jpaorderservice.domain.Customer;
import random.jpaorderservice.domain.Product;
import random.jpaorderservice.domain.ProductStatus;
import random.jpaorderservice.repositories.CustomerRepository;
import random.jpaorderservice.services.ProductService;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final BootstrapOrderService bootstrapOrderService;
    private final CustomerRepository customerRepository;
    private final ProductService productService;

    private void updateProduct() {
        Product product = new Product();
        product.setDescription("My Product");
        product.setProductStatus(ProductStatus.NEW);

        Product savedProduct = productService.saveProduct(product);

        Product savedProduct2 = productService.updateQOH(savedProduct.getId(), 25);

        System.out.println("Updated Qty: " + savedProduct2.getQuantityOnHand());
    }

    @Override
    public void run(String... args) {
        updateProduct();

        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setCustomerName("Testing Version");
        Customer savedCustomer = customerRepository.save(customer);
        System.out.println("Version is: " + savedCustomer.getVersion());

        savedCustomer.setCustomerName("Testing Version 2");
        Customer savedCustomer2 = customerRepository.save(savedCustomer);
        System.out.println("Version is: " + savedCustomer2.getVersion());

        savedCustomer2.setCustomerName("Testing Version 3");
        Customer savedCustomer3 = customerRepository.save(savedCustomer2);
        System.out.println("Version is: " + savedCustomer3.getVersion());

        customerRepository.delete(savedCustomer3);
    }
}