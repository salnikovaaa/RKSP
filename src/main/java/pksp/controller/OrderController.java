package pksp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pksp.models.Client;
import pksp.models.Order;
import pksp.service.ClientService;
import pksp.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    public final OrderService orderService;



    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") @Valid UUID id) {
        return orderService.findOrderById(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }


    @PostMapping
    public void saveCake(@RequestBody @Valid Order order){
        orderService.saveOrder(order);
    }

    @PutMapping
    public void update(@RequestBody @Valid Order order) {
        orderService.updateOrder(order);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        orderService.deleteOrder(id);
    }
}
