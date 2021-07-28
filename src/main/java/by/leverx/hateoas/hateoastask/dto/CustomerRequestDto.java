package by.leverx.hateoas.hateoastask.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Valeryia Zubrytskaya
 */
@Data
public class CustomerRequestDto {

    protected Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

}
