package random.jpacreditcard.domain;

import lombok.Getter;
import lombok.Setter;
import random.jpacreditcard.interceptors.EncryptedString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EncryptedString
    private String creditCardNumber;
    private String cvv;
    private String expirationDate;
}
