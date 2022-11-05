package random.jpamultidb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import random.jpamultidb.domain.cardholder.CreditCardHolder;
import random.jpamultidb.domain.creditcard.CreditCard;
import random.jpamultidb.domain.pan.CreditCardPAN;
import random.jpamultidb.repositories.cardholder.CreditCardHolderRepository;
import random.jpamultidb.repositories.creditcard.CreditCardRepository;
import random.jpamultidb.repositories.pan.CreditCardPANRepository;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardHolderRepository creditCardHolderRepository;
    private final CreditCardRepository creditCardRepository;
    private final CreditCardPANRepository creditCardPANRepository;

    @Transactional
    @Override
    public CreditCard getCreditCardById(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).orElseThrow();
        CreditCardHolder creditCardHolder = creditCardHolderRepository.findByCreditCardId(id).orElseThrow();
        CreditCardPAN creditCardPAN = creditCardPANRepository.findByCreditCardId(id).orElseThrow();

        creditCard.setFirstName(creditCardHolder.getFirstName());
        creditCard.setLastName(creditCardHolder.getLastName());
        creditCard.setZipCode(creditCard.getZipCode());
        creditCard.setCreditCardNumber(creditCardPAN.getCreditCardNumber());

        return creditCard;
    }

    @Transactional
    @Override
    public CreditCard saveCreditCard(CreditCard cc) {
        CreditCard savedCC = creditCardRepository.save(cc);
        savedCC.setFirstName(cc.getFirstName());
        savedCC.setLastName(cc.getLastName());
        savedCC.setZipCode(cc.getCreditCardNumber());
        savedCC.setCreditCardNumber(cc.getCreditCardNumber());

        creditCardHolderRepository.save(CreditCardHolder.builder()
                .creditCardId(savedCC.getId())
                .firstName(savedCC.getFirstName())
                .lastName(savedCC.getLastName())
                .zipCode(savedCC.getZipCode())
                .build());

        creditCardPANRepository.save(CreditCardPAN.builder()
                .creditCardNumber(savedCC.getCreditCardNumber())
                .creditCardId(savedCC.getId())
                .build());

        return savedCC;
    }
}
