package random.jpacreditcard.domain;

import lombok.Getter;
import lombok.Setter;
import random.jpacreditcard.interceptors.EncryptedString;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@EntityListeners(CreditCardJPACallback.class)
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@EncryptedString
    @Convert(converter = CreditCardConverter.class)
    private String creditCardNumber;
    private String cvv;
    private String expirationDate;

    @PrePersist
    public void prePersistCallback(){
        System.out.println("JPA PrePersist Callback was called");
    }
}
