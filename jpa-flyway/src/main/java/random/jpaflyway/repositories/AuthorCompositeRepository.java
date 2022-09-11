package random.jpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaflyway.domain.composite.AuthorComposite;
import random.jpaflyway.domain.composite.NameId;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
