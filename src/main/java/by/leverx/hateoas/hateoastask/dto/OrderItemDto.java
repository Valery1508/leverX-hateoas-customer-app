package by.leverx.hateoas.hateoastask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Valeryia Zubrytskaya
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto extends RepresentationModel<OrderItemDto> {

    protected Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Double price;
}
