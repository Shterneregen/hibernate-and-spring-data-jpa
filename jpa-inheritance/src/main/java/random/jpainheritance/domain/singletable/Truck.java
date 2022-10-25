package random.jpainheritance.domain.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle{
    private Integer payload;
}
