package random.sdjpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaflyway.domain.BookUuid;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
