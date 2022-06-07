package pksp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pksp.dto.ClientDto;
import pksp.models.Client;
import pksp.service.ClientService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/client")

public class ClientControllerApi {

    public final ClientService clientService;

    @Autowired
    public ClientControllerApi(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/{id}")
    public Client getById(@PathVariable("id")  Long id) {
        return clientService.findClientById(id);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }


    @PostMapping
    public void saveCake(@RequestBody @Valid ClientDto client) {
        clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public void update(
            @RequestBody @Valid ClientDto client,
            @PathVariable("id") Long id
    ) {
        clientService.updateClient(client, id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }
}
