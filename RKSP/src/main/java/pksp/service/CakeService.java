package pksp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pksp.dao.CakeRepository;
import pksp.dto.CakeDto;
import pksp.models.Cake;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CakeService {


    private final CakeRepository repository;

    @Autowired
    public CakeService(CakeRepository repository) {
        this.repository = repository;
    }

    public void saveCake(CakeDto cakes) {
        Cake entity = new Cake();
        entity.setPrice(cakes.getPrice())
                .setDescription(cakes.getDescription())
                .setName(cakes.getName());

        repository.save(entity);
    }

    public Cake findCakesById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cakes not found by id=" + id));
    }

    public List<Cake> findAll() {
        return repository.findAll();
    }


    public Cake updateCake(CakeDto cake, Long cakeId) {
        Cake entity = findCakesById(cakeId);

        entity
                .setDescription(cake.getDescription())
                .setCompound(cake.getCompound())
                .setName(cake.getName())
                .setPrice(cake.getPrice());

        return repository.save(entity);
    }

    public void deleteCake(Long id) {
        repository.deleteById(id);
    }
}
