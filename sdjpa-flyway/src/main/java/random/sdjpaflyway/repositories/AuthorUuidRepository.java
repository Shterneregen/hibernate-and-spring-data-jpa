package random.sdjpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaflyway.domain.AuthorUuid;

import java.util.UUID;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
