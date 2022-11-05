package random.jpamultidb.repositories.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpamultidb.domain.cardholder.CreditCardHolder;

import java.util.Optional;

public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long> {
    Optional<CreditCardHolder> findByCreditCardId(Long id);
}
