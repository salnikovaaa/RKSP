package pksp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pksp.dao.ClientRepository;
import pksp.dao.OrderRepository;
import pksp.dto.OrderDto;
import pksp.models.Cake;
import pksp.models.Client;
import pksp.models.Order;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ClientService clientService;
    private final ClientRepository clientRepository;

    private final CakeService cakeService;

    @Autowired
    public OrderService(
            OrderRepository repository,
            ClientService clientService,
            ClientRepository clientRepository, CakeService cakeService
    ) {
        this.repository = repository;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.cakeService = cakeService;
    }

    public void saveOrder(OrderDto order) {
        Order entity = new Order();
        entity
                .setEmail(order.getEmail())
                .setName(order.getName())
                .setPhoneNumber(order.getPhoneNumber());

        Optional<Client> clientOptional = clientService.findByNubmer(order.getPhoneNumber());
        Cake cake = cakeService.findCakesById(order.getCakeId());
        entity
                .setCake(cake)
                .setCakeId(cake.getId());

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            entity
                    .setClient(client)
                    .setClientId(client.getId());
        }
        else {
            Client newClient = new Client();
            newClient
                    .setPhoneNumber(order.getPhoneNumber())
                    .setName(order.getName())
                    .setEmail(order.getEmail());

            clientRepository.save(newClient);

            entity
                    .setClient(newClient)
                    .setClientId(newClient.getId());
        }

        repository.save(entity);
    }

    public Order findOrderById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Order not found by id=" + id)
        );
    }

    public List<Order> findAll() {
        return repository.findAll();
    }


    public void updateOrder(OrderDto order, Long orderId) {
        Order entity = findOrderById(orderId);
        repository.save(entity);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
