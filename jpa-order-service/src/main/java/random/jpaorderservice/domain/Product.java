package random.jpaorderservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Product extends BaseEntity {
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}
