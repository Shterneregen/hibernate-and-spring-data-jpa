package random.jpaorderservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class OrderApproval extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "order_header_id")
    private OrderHeader orderHeader;
    private String approvedBy;
}
