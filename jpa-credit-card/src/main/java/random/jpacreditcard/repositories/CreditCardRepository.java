package random.jpacreditcard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpacreditcard.domain.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
