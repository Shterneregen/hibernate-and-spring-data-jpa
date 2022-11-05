package random.jpamultidb.repositories.pan;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpamultidb.domain.pan.CreditCardPAN;

import java.util.Optional;

public interface CreditCardPANRepository extends JpaRepository<CreditCardPAN, Long> {
    Optional<CreditCardPAN> findByCreditCardId(Long id);
}
