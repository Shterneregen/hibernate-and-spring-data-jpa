package random.jpaorderservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AttributeOverrides({
        @AttributeOverride(name = "shippingAddress.address", column = @Column(name = "shipping_address")),
        @AttributeOverride(name = "shippingAddress.city", column = @Column(name = "shipping_city")),
        @AttributeOverride(name = "shippingAddress.state", column = @Column(name = "shipping_state")),
        @AttributeOverride(name = "shippingAddress.zipCode", column = @Column(name = "shipping_zip_code")),
        @AttributeOverride(name = "billToAddress.address", column = @Column(name = "bill_to_address")),
        @AttributeOverride(name = "billToAddress.city", column = @Column(name = "bill_to_city")),
        @AttributeOverride(name = "billToAddress.state", column = @Column(name = "bill_to_state")),
        @AttributeOverride(name = "billToAddress.zipCode", column = @Column(name = "bill_to_zip_code"))
})
@Entity
public class OrderHeader extends BaseEntity {
    @ManyToOne
    private Customer customer;
    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billToAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "orderHeader", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<OrderLine> orderLines;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private OrderApproval orderApproval;

    public void addOrderLine(OrderLine orderLine) {
        if (orderLines == null) {
            orderLines = new HashSet<>();
        }
        orderLines.add(orderLine);
        orderLine.setOrderHeader(this);
    }
}
