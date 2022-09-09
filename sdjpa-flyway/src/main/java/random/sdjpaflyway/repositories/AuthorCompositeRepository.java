package random.sdjpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaflyway.domain.composite.AuthorComposite;
import random.sdjpaflyway.domain.composite.NameId;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
