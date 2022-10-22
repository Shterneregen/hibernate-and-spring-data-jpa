package random.jpaorderservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final BootstrapOrderService bootstrapOrderService;

    @Override
    public void run(String... args) {
        bootstrapOrderService.readOrderData();
    }
}