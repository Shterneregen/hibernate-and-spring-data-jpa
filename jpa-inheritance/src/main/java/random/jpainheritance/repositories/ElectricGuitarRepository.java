package random.jpainheritance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpainheritance.domain.joined.ElectricGuitar;

public interface ElectricGuitarRepository extends JpaRepository<ElectricGuitar, Long> {
}
