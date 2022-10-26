package random.jpawp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "wp_usermeta")
public class UserMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umeta_id")
    private Long id;
    private Long userId;
    @Size(max = 255)
    @Column(columnDefinition = "longtext")
    private String metaKey;

    @Lob
    private String metaValue;
}
