package by.leverx.hateoas.hateoastask.service;

import by.leverx.hateoas.hateoastask.dto.CustomerRequestDto;
import by.leverx.hateoas.hateoastask.dto.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
public interface CustomerService {

    Optional<CustomerResponseDto> getCustomerById(Long id);

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

    List<CustomerResponseDto> getCustomers();
}
