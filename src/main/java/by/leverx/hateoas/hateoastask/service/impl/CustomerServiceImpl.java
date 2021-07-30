package by.leverx.hateoas.hateoastask.service.impl;

import by.leverx.hateoas.hateoastask.dto.CustomerRequestDto;
import by.leverx.hateoas.hateoastask.dto.CustomerResponseDto;
import by.leverx.hateoas.hateoastask.entity.Customer;
import by.leverx.hateoas.hateoastask.exception.EntityNotFoundException;
import by.leverx.hateoas.hateoastask.mapper.CustomerMapper;
import by.leverx.hateoas.hateoastask.repository.CustomerRepository;
import by.leverx.hateoas.hateoastask.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Valeryia Zubrytskaya
 */
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerResponseDto> getCustomerById(Long id) {

        if (!checkExistence(id)) {
            throw new EntityNotFoundException(Customer.class.getName(), id);
        }

        Optional<Customer> customer = customerRepository.findById(id);

        return customer
                .map(customerMapper::toDto);

    }

    @Override
    @Transactional
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = customerMapper.toEntity(customerRequestDto);
        customerRepository.save(customer);

        return getCustomerById(customer.getId()).get();

    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponseDto> getCustomers() {

        List<Customer> customers = customerRepository.findAll();
        return customerMapper.listToDtos(customers);

    }

    @Override
    @Transactional
    public void deleteCustomerById(Long id) {
        if (checkExistence(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Customer.class.getName(), id);
        }
    }

    @Override
    @Transactional
    public CustomerResponseDto updateCustomerById(Long id, CustomerRequestDto customerRequestDto) {
        if (!checkExistence(id)) {
            throw new EntityNotFoundException(Customer.class.getName(), id);
        }

        customerRequestDto.setId(id);
        Customer customer = customerMapper.toEntity(customerRequestDto);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toDto(savedCustomer);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkExistence(Long id) {
        return customerRepository.existsById(id);
    }

}
