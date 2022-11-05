package random.jpamultidb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import random.jpamultidb.domain.creditcard.CreditCard;
import random.jpamultidb.services.CreditCardService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaMultiDbApplicationTests {

    @Autowired
    private CreditCardService creditCardService;

    @Test
    void testSaveAndGetCreditCard() {
        CreditCard cc = CreditCard.builder()
                .firstName("John")
                .lastName("Thompson")
                .zipCode("12345")
                .creditCardNumber("1234556")
                .cvv("123")
                .expirationDate("12/26")
                .build();

        CreditCard savedCC = creditCardService.saveCreditCard(cc);

        assertThat(savedCC).isNotNull();
        assertThat(savedCC.getId()).isNotNull();
        assertThat(savedCC.getCreditCardNumber()).isNotNull();

        CreditCard fetchedCreditCard = creditCardService.getCreditCardById(savedCC.getId());

        assertThat(fetchedCreditCard).isNotNull();
        assertThat(fetchedCreditCard.getId()).isNotNull();
        assertThat(fetchedCreditCard.getCreditCardNumber()).isNotNull();
    }

    @Test
    void contextLoads() {
    }

}
