package by.leverx.hateoas.hateoastask.dto;

import by.leverx.hateoas.hateoastask.entity.Order;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author Valeryia Zubrytskaya
 */
@Data
public class CustomerResponseDto {

    protected Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    private Set<Order> orders;
}
