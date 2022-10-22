package random.jpaorderservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import random.jpaorderservice.domain.OrderHeader;
import random.jpaorderservice.repositories.OrderHeaderRepository;

@RequiredArgsConstructor
@Service
public class BootstrapOrderService {
    private final OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData() {
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
