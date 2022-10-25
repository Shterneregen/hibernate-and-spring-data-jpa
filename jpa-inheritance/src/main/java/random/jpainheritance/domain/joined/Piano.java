package random.jpainheritance.domain.joined;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Piano extends Instrument {
    private Integer numberOfKeys;
}
