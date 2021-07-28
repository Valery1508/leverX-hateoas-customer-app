package by.leverx.hateoas.hateoastask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

import static java.util.Collections.emptySet;

/**
 * @author Valeryia Zubrytskaya
 */
@Entity
@Data
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;  // TODO: 7/28/2021 : current time + 10 days

    private Double totalOrderCost;

    @OneToMany(/*mappedBy = "order", */cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = emptySet();

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        this.totalOrderCost = totalOrderCost + orderItem.getPrice();
    }
}
