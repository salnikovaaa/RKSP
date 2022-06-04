package pksp.service;


import org.springframework.stereotype.Service;
import pksp.dao.CakeRepository;
import pksp.models.Cake;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class CakeService {


    private final CakeRepository repository;

    public CakeService(CakeRepository repository) {
        this.repository = repository;
    }

    public void saveCake(Cake cakes) {
        repository.saveCakes(cakes);
    }

    public Cake findCakesById(UUID id) {
        return repository.findCakesById(id).orElseThrow(() -> new EntityNotFoundException("Cakes not found by id=" + id));
    }

    public List<Cake> findAll() {
        return repository.findAll();
    }



    public void updateCake(Cake cake) {
        repository.updateCakes(cake);
    }

    public void deleteCake(UUID id){repository.deleteCakes(id);}
}
