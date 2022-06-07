package pksp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pksp.dto.OrderDto;
import pksp.models.Order;
import pksp.service.OrderService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/order")

public class OrderControllerApi {
    public final OrderService orderService;

    @Autowired
    public OrderControllerApi(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") @Valid Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }




    @PutMapping("/{id}")
    public void update(
            @RequestBody @Valid OrderDto order,
            @PathVariable("id") Long orderId
            ) {
        orderService.updateOrder(order, orderId);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
