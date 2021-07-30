package by.leverx.hateoas.hateoastask.controller;

import by.leverx.hateoas.hateoastask.dto.CustomerRequestDto;
import by.leverx.hateoas.hateoastask.dto.CustomerResponseDto;
import by.leverx.hateoas.hateoastask.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Valeryia Zubrytskaya
 */

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {

        CustomerResponseDto receivedCustomer = customerService.getCustomerById(id).get();

        receivedCustomer.add(linkTo(methodOn(CustomerController.class)
                .getCustomerById(receivedCustomer.getId()))
                .withSelfRel());

        receivedCustomer.add(linkTo(methodOn(CustomerController.class)
                .deleteCustomerById(receivedCustomer.getId()))
                .withRel("delete"));

        receivedCustomer.add(linkTo(methodOn(CustomerController.class)
                .deleteCustomerById(receivedCustomer.getId()))
                .withRel("update"));

        return ResponseEntity.ok(receivedCustomer);
    }

    @GetMapping
    public List<CustomerResponseDto> getCustomers() {

        return customerService.getCustomers();

    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {

        CustomerResponseDto createdCustomer = customerService.createCustomer(customerRequestDto);

        createdCustomer.add(linkTo(methodOn(CustomerController.class)
                .createCustomer(customerRequestDto))
                .withSelfRel());

        createdCustomer.add(linkTo(methodOn(CustomerController.class)
                .getCustomerById(createdCustomer.getId()))
                .withRel("get"));

        return ResponseEntity.ok(createdCustomer);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {

        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer with id=" + id + " was successfully deleted");

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomerById(@PathVariable Long id, @Valid @RequestBody CustomerRequestDto customerRequestDto) {

        CustomerResponseDto updatedCustomer = customerService.updateCustomerById(id, customerRequestDto);

        updatedCustomer.add(linkTo(methodOn(CustomerController.class)
                .getCustomerById(updatedCustomer.getId()))
                .withSelfRel());

        updatedCustomer.add(linkTo(methodOn(CustomerController.class)
                .getCustomerById(updatedCustomer.getId()))
                .withRel("get"));

        updatedCustomer.add(linkTo(methodOn(CustomerController.class)
                .deleteCustomerById(updatedCustomer.getId()))
                .withRel("delete"));

        return ResponseEntity.ok(updatedCustomer);

    }
}