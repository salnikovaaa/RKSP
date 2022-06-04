package pksp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pksp.models.Cake;
import pksp.models.Client;
import pksp.service.CakeService;
import pksp.service.ClientService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    public final ClientService clientService;



    @GetMapping("/{id}")
    public Client getById(@PathVariable("id") @Valid UUID id) {
        return clientService.findClientById(id);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }


    @PostMapping
    public void saveCake(@RequestBody @Valid Client client){
        clientService.saveClient(client);
    }

    @PutMapping
    public void update(@RequestBody @Valid Client client) {
        clientService.updateClient(client);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }
}
