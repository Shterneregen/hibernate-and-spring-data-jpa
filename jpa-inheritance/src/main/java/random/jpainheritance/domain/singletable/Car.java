package random.jpainheritance.domain.singletable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle{
    private String trimLevel;
}
