package random.jpacreditcard.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import random.jpacreditcard.domain.CreditCard;
import random.jpacreditcard.services.EncryptionService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreditCardRepositoryTest {

    final String CREDIT_CARD = "12345678900000";

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private EncryptionService encryptionService;

    @Test
    void testSaveAndStoreCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber(CREDIT_CARD);
        creditCard.setCvv("123");
        creditCard.setExpirationDate("12/2028");

        CreditCard savedCC = creditCardRepository.saveAndFlush(creditCard);

        System.out.println("Getting CC from database: " + creditCard.getCreditCardNumber());

        System.out.println("CC At Rest");
        System.out.println("CC Encrypted: " + encryptionService.encrypt(CREDIT_CARD));

        CreditCard fetchedCC = creditCardRepository.findById(savedCC.getId()).get();

        assertThat(savedCC.getCreditCardNumber()).isEqualTo(fetchedCC.getCreditCardNumber());
    }
}
