package random.jpacreditcard.domain;

import random.jpacreditcard.config.SpringContextHelper;
import random.jpacreditcard.services.EncryptionService;

import javax.persistence.*;

public class CreditCardJPACallback {

    @PrePersist
    @PreUpdate
    public void beforeInsertOrUpdate(CreditCard creditCard) {
        System.out.println("before update was called...");
        creditCard.setCreditCardNumber(getEncryptionService().encrypt(creditCard.getCreditCardNumber()));
    }

    @PostPersist
    @PostLoad
    @PostUpdate
    public void postLoad(CreditCard creditCard) {
        System.out.println("Post Load was called...");
        creditCard.setCreditCardNumber(getEncryptionService().decrypt(creditCard.getCreditCardNumber()));
    }

    private EncryptionService getEncryptionService() {
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
