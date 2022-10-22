package random.jpaorderservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import random.jpaorderservice.domain.OrderHeader;
import random.jpaorderservice.repositories.OrderHeaderRepository;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final OrderHeaderRepository orderHeaderRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();

        orderHeader.getOrderLines().forEach(ol -> {
            System.out.println(ol.getProduct().getDescription());

            // If we're outside transactional context, so we're outside the session.
            // Categories are lazy. It needs to issue another database statement, but we're outside the session.
            // Solution is mark the method as @Transactional
            ol.getProduct().getCategories().forEach(cat -> {
                System.out.println(cat.getDescription());
            });
        });
    }
}