package random.jpaorderservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity {

    private String customerName;

    @Embedded
    private Address address;

    private String phone;
    private String email;
    @Version
    private Integer version;

    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orders = new LinkedHashSet<>();
}
