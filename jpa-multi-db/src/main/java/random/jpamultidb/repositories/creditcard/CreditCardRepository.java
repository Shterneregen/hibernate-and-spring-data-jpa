package random.jpamultidb.repositories.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpamultidb.domain.creditcard.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
