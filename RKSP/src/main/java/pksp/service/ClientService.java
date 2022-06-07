package pksp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pksp.dao.ClientRepository;
import pksp.dto.ClientDto;
import pksp.models.Client;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void saveClient(ClientDto client) {
        Client entity = new Client();

        repository.save(entity);
    }

    public Client findClientById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found by id=" + id));
    }

    public List<Client> findAll() {
        return repository.findAll();
    }


    public void updateClient(ClientDto client, Long clientId) {
        Client entity = findClientById(clientId);
        entity
                .setEmail(client.getEmail())
                .setName(client.getName())
                .setPhoneNumber(client.getPhoneNumber());

        repository.save(entity);
    }

    public Optional<Client> findByNubmer(String number){
       return repository.findByPhoneNumber(number);
    }
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
