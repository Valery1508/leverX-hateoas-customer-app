package by.leverx.hateoas.hateoastask.dto;

import by.leverx.hateoas.hateoastask.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Links;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author Valeryia Zubrytskaya
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    protected Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotNull
    private Set<Order> orders;

    private Links links;
}
