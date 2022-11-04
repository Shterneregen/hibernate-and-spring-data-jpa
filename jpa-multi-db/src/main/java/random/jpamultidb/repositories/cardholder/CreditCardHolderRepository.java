package random.jpamultidb.repositories.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpamultidb.domain.cardholder.CreditCardHolder;

public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long> {
}
