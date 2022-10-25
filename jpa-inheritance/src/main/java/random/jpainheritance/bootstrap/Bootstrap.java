package random.jpainheritance.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.jpainheritance.domain.joined.ElectricGuitar;
import random.jpainheritance.repositories.ElectricGuitarRepository;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final ElectricGuitarRepository electricGuitarRepository;

    @Override
    public void run(String... args) {
        ElectricGuitar eg = new ElectricGuitar();
        eg.setNumberOfStrings(6);
        eg.setNumberOfPickups(2);
        electricGuitarRepository.save(eg);
    }
}
