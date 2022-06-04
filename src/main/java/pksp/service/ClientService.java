package pksp.service;

import org.springframework.stereotype.Service;
import pksp.dao.CakeRepository;
import pksp.dao.ClientRepository;
import pksp.models.Cake;
import pksp.models.Client;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {


    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void saveClient(Client client) {
        repository.saveClients(client);
    }

    public Client findClientById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found by id=" + id));
    }

    public List<Client> findAll() {
        return repository.findAll();
    }



    public void updateClient(Client client) {
        repository.updateClient(client);
    }

    public void deleteClient(UUID id){repository.deleteClient(id);}
}
