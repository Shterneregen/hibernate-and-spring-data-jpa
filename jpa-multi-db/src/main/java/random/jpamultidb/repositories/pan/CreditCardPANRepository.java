package random.jpamultidb.repositories.pan;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpamultidb.domain.pan.CreditCardPAN;

public interface CreditCardPANRepository extends JpaRepository<CreditCardPAN, Long> {
}
