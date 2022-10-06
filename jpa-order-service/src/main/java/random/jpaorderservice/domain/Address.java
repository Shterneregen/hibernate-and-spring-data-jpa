package random.jpaorderservice.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
