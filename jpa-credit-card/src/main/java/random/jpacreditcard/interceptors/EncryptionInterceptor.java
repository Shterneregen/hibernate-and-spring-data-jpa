package random.jpacreditcard.interceptors;

import lombok.RequiredArgsConstructor;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import random.jpacreditcard.services.EncryptionService;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
//@Component
public class EncryptionInterceptor extends EmptyInterceptor {
    private final EncryptionService encryptionService;

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        System.out.println("I'm in onFlushDirty");
        Object[] newState = processFields(entity, currentState, propertyNames, "onFlushDirty");
        return super.onFlushDirty(entity, id, newState, previousState, propertyNames, types);
    }

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("I'm in onLoad");
        Object[] newState = processFields(entity, state, propertyNames, "onLoad");
        return super.onLoad(entity, id, newState, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("I'm in onSave");
        Object[] newState = processFields(entity, state, propertyNames, "onSave");
        return super.onSave(entity, id, newState, propertyNames, types);
    }

    private Object[] processFields(Object entity, Object[] state, String[] propertyNames, String type) {
        List<String> annotationFields = getAnnotationFields(entity);

        for (String field : annotationFields) {
            for (int i = 0; i < propertyNames.length; i++) {
                if (propertyNames[i].equals(field) && StringUtils.hasText(state[i].toString())) {
                    if ("onSave".equals(type) || "onFlushDirty".equals(type)) {
                        state[i] = encryptionService.encrypt(state[i].toString());
                    } else if ("onLoad".equals(type)) {
                        state[i] = encryptionService.decrypt(state[i].toString());
                    }
                }
            }
        }

        return state;
    }

    private List<String> getAnnotationFields(Object entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> !Objects.isNull(field.getAnnotation(EncryptedString.class)))
                .map(Field::getName)
                .toList();
    }
}
