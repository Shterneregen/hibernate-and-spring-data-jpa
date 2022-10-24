package random.jpainheritance.domain.msuper;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class OrderHeader extends BaseEntity {
    private String customerName;
}
