package random.jpamultidb.domain;

import random.jpamultidb.config.SpringContextHelper;
import random.jpamultidb.services.EncryptionService;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CreditCardConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return getEncryptionService().encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return getEncryptionService().decrypt(dbData);
    }

    private EncryptionService getEncryptionService(){
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
