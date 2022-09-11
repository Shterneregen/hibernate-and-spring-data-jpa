package random.jpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaflyway.domain.BookUuid;

import java.util.UUID;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}
