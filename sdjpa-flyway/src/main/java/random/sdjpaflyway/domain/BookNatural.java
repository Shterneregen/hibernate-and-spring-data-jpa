package random.sdjpaflyway.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class BookNatural {
    @Id
    private String title;
    private String isbn;
    private String publisher;
}
