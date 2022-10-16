package random.jpaorderservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class OrderApproval extends BaseEntity {

    private String approvedBy;
}
