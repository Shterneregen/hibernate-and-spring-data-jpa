package random.jpaorderservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class OrderLine extends BaseEntity {
    @Version
    private Integer version;
    private Integer quantityOrdered;
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private OrderHeader orderHeader;
    @ManyToOne
    private Product product;
}
