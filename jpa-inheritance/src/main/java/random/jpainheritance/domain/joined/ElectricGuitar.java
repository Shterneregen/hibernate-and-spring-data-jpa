package random.jpainheritance.domain.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class ElectricGuitar extends Guitar{
    private Integer numberOfPickups;
}
