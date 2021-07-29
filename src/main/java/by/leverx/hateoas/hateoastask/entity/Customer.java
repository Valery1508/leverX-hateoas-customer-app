package by.leverx.hateoas.hateoastask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashSet;

/**
 * @author Valeryia Zubrytskaya
 */

@Entity
@Getter
@Setter
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends RepresentationModel<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Order> orders = newHashSet();

    public void addOrder(Order order) {
        orders.add(order);
    }

}
