package by.leverx.hateoas.hateoastask.service.impl;

import by.leverx.hateoas.hateoastask.controller.CustomerController;
import by.leverx.hateoas.hateoastask.dto.CustomerRequestDto;
import by.leverx.hateoas.hateoastask.dto.CustomerResponseDto;
import by.leverx.hateoas.hateoastask.entity.Customer;
import by.leverx.hateoas.hateoastask.mapper.CustomerMapper;
import by.leverx.hateoas.hateoastask.repository.CustomerRepository;
import by.leverx.hateoas.hateoastask.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Valeryia Zubrytskaya
 */
@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Optional<CustomerResponseDto> getCustomerById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        customer.get().add(linkTo(methodOn(CustomerController.class)    // TODO: 7/28/2021 doesn't work
                .getCustomer(customer.get().getId()))
                .withSelfRel());
        return customer
                .map(customerMapper::toDto);    // TODO: 7/28/2021 exception
    }

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.toEntity(customerRequestDto);
        customerRepository.save(customer);

        return getCustomerById(customer.getId()).get();
    }

}
