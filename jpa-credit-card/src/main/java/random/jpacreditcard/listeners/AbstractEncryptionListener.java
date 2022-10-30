package random.jpacreditcard.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import random.jpacreditcard.interceptors.EncryptedString;
import random.jpacreditcard.services.EncryptionService;

import java.lang.reflect.Field;

@RequiredArgsConstructor
public abstract class AbstractEncryptionListener {
    private final EncryptionService encryptionService;

    public void encrypt(Object[] state, String[] propertyNames, Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> encryptField(field, state, propertyNames), this::isFieldEncrypted);
    }

    private void encryptField(Field field, Object[] state, String[] propertyNames) {
        int idx = getPropertyIndex(field.getName(), propertyNames);
        Object currentValue = state[idx];
        state[idx] = encryptionService.encrypt(currentValue.toString());
    }

    public void decrypt(Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> decryptField(field, entity), this::isFieldEncrypted);
    }

    private void decryptField(Field field, Object entity) {
        field.setAccessible(true);
        Object value = ReflectionUtils.getField(field, entity);
        if (value != null) {
            ReflectionUtils.setField(field, entity, encryptionService.decrypt(value.toString()));
        }
    }

    public boolean isFieldEncrypted(Field field) {
        return AnnotationUtils.findAnnotation(field, EncryptedString.class) != null;
    }

    public int getPropertyIndex(String name, String[] properties) {
        for (int i = 0; i < properties.length; i++) {
            if (name.equals(properties[i])) {
                return i;
            }
        }

        //should never get here...
        throw new IllegalArgumentException("Property not found: " + name);
    }
}
