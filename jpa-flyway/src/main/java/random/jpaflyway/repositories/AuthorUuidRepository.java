package random.jpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaflyway.domain.AuthorUuid;

import java.util.UUID;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
