package random.jpaorderservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.jpaorderservice.domain.Customer;
import random.jpaorderservice.repositories.CustomerRepository;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final BootstrapOrderService bootstrapOrderService;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setCustomerName("Testing Version");
        Customer savedCustomer = customerRepository.save(customer);

        System.out.println("Version is: " + savedCustomer.getVersion());

        customerRepository.deleteById(savedCustomer.getId());
    }
}