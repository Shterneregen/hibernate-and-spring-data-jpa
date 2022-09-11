package random.jpaflyway.domain.composite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "author_composite") // still the same table as in AuthorComposite class
public class AuthorEmbedded {
    @EmbeddedId
    private NameId nameId;
    private String country;
}
