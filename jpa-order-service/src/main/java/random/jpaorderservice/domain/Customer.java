package random.jpaorderservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity {
    @Size(max = 50)
    private String customerName;

    @Valid
    @Embedded
    private Address address;

    @Size(max = 20)
    private String phone;
    @Size(max = 255)
    @Email
    private String email;
    @Version
    private Integer version;

    @OneToMany(mappedBy = "customer")
    private Set<OrderHeader> orders = new LinkedHashSet<>();
}
