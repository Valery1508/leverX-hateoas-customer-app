package by.leverx.hateoas.hateoastask.mapper;

import by.leverx.hateoas.hateoastask.dto.CustomerRequestDto;
import by.leverx.hateoas.hateoastask.dto.CustomerResponseDto;
import by.leverx.hateoas.hateoastask.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Valeryia Zubrytskaya
 */
@Component
@AllArgsConstructor
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDto customerRequestDto){
        Customer customer = new Customer();
        customer.setId(customerRequestDto.getId());
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setAddress(customerRequestDto.getAddress());
        return customer;
    }

    public CustomerResponseDto toDto(Customer customer){
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setFirstName(customer.getFirstName());
        customerResponseDto.setLastName(customer.getLastName());
        customerResponseDto.setAddress(customer.getAddress());
        customerResponseDto.setOrders(customer.getOrders());
        return customerResponseDto;
    }
}
