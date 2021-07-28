package by.leverx.hateoas.hateoastask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Valeryia Zubrytskaya
 */

@EqualsAndHashCode(callSuper = false) // TODO: 7/28/2021
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto extends RepresentationModel<OrderItemDto> {

    protected Long id;

    @NotBlank/*(message = NULL_OR_EMPTY_FIELD_MESSAGE)*/    // TODO: 7/28/2021
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Double price;

}
