package random.jpaorderservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class OrderLine extends BaseEntity {
    private Integer quantityOrdered;
    @ManyToOne
    private OrderHeader orderHeader;
}
