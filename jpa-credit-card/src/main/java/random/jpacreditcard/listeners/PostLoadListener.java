package random.jpacreditcard.listeners;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.springframework.stereotype.Component;
import random.jpacreditcard.services.EncryptionService;

@Component
public class PostLoadListener extends AbstractEncryptionListener implements PostLoadEventListener {
    public PostLoadListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public void onPostLoad(PostLoadEvent event) {
        System.out.println("In Post Load");

        this.decrypt(event.getEntity());
    }
}
