package pksp.service;

import org.springframework.stereotype.Service;
import pksp.dao.CakeRepository;
import pksp.dao.OrderRepository;
import pksp.models.Cake;
import pksp.models.Order;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void saveOrder(Order order) {
        repository.saveOrder(order);
    }

    public Order findOrderById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order not found by id=" + id));
    }

    public List<Order> findAll() {
        return repository.findAll();
    }



    public void updateOrder(Order order) {
        repository.updateOrder(order);
    }

    public void deleteOrder(UUID id){repository.deleteOrder(id);}
}
