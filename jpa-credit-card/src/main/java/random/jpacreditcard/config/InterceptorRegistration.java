package random.jpacreditcard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;
import random.jpacreditcard.interceptors.EncryptionInterceptor;

import java.util.Map;

//@Configuration
public class InterceptorRegistration implements HibernatePropertiesCustomizer {

//    @Autowired
//    private EncryptionInterceptor interceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
//        hibernateProperties.put("hibernate.session_factory.interceptor", interceptor);
    }
}
