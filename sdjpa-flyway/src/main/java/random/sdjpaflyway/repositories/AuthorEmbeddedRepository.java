package random.sdjpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaflyway.domain.composite.AuthorEmbedded;
import random.sdjpaflyway.domain.composite.NameId;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
