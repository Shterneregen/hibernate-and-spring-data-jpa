package random.jpainheritance.domain.tableperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Dog extends Mammal {
    private String breed;
}
