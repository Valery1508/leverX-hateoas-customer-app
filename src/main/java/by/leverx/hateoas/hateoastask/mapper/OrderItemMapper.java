package by.leverx.hateoas.hateoastask.mapper;

import by.leverx.hateoas.hateoastask.dto.OrderItemDto;
import by.leverx.hateoas.hateoastask.entity.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Valeryia Zubrytskaya
 */
@Component
@AllArgsConstructor
public class OrderItemMapper {

    public OrderItem toEntity(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setName(orderItemDto.getName());
        orderItem.setDescription(orderItemDto.getDescription());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setOrder(orderItem.getOrder());
        return orderItem;
    }

    public OrderItemDto toDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setName(orderItem.getName());
        orderItemDto.setDescription(orderItem.getDescription());
        orderItemDto.setPrice(orderItem.getPrice());
        return orderItemDto;
    }

    public List<OrderItemDto> listToDtos(List<OrderItem> orderItems) {
        return orderItems.stream().map(this::toDto).collect(toList());
    }
}
