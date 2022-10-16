package random.jpaorderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaorderservice.domain.OrderApproval;

public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}
