package pksp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pksp.models.Cake;
import pksp.models.Client;
import pksp.models.Order;
import pksp.service.CakeService;
import pksp.service.ClientService;
import pksp.service.OrderService;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
}
    @Bean
    ApplicationRunner applicationRunner(CakeService cakeService, ClientService clientService, OrderService orderService) {
        return args -> {


            // create and save

            Cake cheescake = new Cake(UUID.randomUUID(),"Cheescake", "Tasty", 500 );
            cakeService.saveCake(cheescake);


            UUID uuid = UUID.randomUUID();


            Client mary = new Client(uuid, "Mary", "oaoa@mail.ru", "88005553535");
            clientService.saveClient(mary);

            Order order1 = new Order(UUID.randomUUID(), mary.getId(), cheescake.getId(), 5, 2500);
            orderService.saveOrder(order1);





            //find by id

            System.out.println(clientService.findClientById(uuid));

            System.out.println(cakeService.findCakesById(cheescake.getId()));

            System.out.println(orderService.findOrderById(order1.getId()));



            // find all
            List<Client> all = clientService.findAll();
            System.out.println(all);

            List<Cake> allCakes = cakeService.findAll();
            System.out.println(allCakes);

            List<Order> allOrder = orderService.findAll();
            System.out.println(allOrder);


            //update

            cheescake.setDescription("Not tasty");

            mary.setEmail("qqq@mail.ru");

            order1.setCount(6);

            cakeService.updateCake(cheescake);

            clientService.updateClient(mary);

            orderService.updateOrder(order1);

            System.out.println(clientService.findClientById(uuid));

            System.out.println(cakeService.findCakesById(cheescake.getId()));

            System.out.println(orderService.findOrderById(order1.getId()));


            //delete

           /* clientService.deleteClient(uuid);

            clientService.findClientById(uuid);*/



        };
    }
}

