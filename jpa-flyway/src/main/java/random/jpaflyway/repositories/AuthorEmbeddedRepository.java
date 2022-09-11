package random.jpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaflyway.domain.composite.AuthorEmbedded;
import random.jpaflyway.domain.composite.NameId;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
