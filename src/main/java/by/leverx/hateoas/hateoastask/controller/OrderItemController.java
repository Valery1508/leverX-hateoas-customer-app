package by.leverx.hateoas.hateoastask.controller;

import by.leverx.hateoas.hateoastask.dto.OrderItemDto;
import by.leverx.hateoas.hateoastask.service.OrderItemService;
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
@RequestMapping("/api/orderItems")
@AllArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable Long id) {

        OrderItemDto receivedOrderItem = orderItemService.getOrderItemById(id).get();

        receivedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .getOrderItemById(receivedOrderItem.getId()))
                .withSelfRel());

        receivedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .deleteOrderItemById(receivedOrderItem.getId()))
                .withRel("delete"));

        receivedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .deleteOrderItemById(receivedOrderItem.getId()))
                .withRel("update"));

        return ResponseEntity.ok(receivedOrderItem);
    }

    @GetMapping
    public List<OrderItemDto> getOrderItems() {

        return orderItemService.getOrderItems();

    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@Valid @RequestBody OrderItemDto orderItemDto) {

        OrderItemDto createdOrderItem = orderItemService.createOrderItem(orderItemDto);

        createdOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .createOrderItem(orderItemDto))
                .withSelfRel());

        createdOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .getOrderItemById(createdOrderItem.getId()))
                .withRel("get"));

        return ResponseEntity.ok(createdOrderItem);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable Long id) {

        orderItemService.deleteOrderItemById(id);
        return ResponseEntity.ok("Order Item with id=" + id + " was successfully deleted");

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderItemDto> updateOrderItemById(@PathVariable Long id, @Valid @RequestBody OrderItemDto orderItemDto) {

        OrderItemDto updatedOrderItem = orderItemService.updateOrderItemById(id, orderItemDto);

        updatedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .getOrderItemById(updatedOrderItem.getId()))
                .withSelfRel());

        updatedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .getOrderItemById(updatedOrderItem.getId()))
                .withRel("get"));

        updatedOrderItem.add(linkTo(methodOn(OrderItemController.class)
                .deleteOrderItemById(updatedOrderItem.getId()))
                .withRel("delete"));

        return ResponseEntity.ok(updatedOrderItem);

    }

}
