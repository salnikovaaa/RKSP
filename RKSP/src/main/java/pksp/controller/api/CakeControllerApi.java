package pksp.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pksp.dto.CakeDto;
import pksp.models.Cake;
import pksp.service.CakeService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/cakes")

public class CakeControllerApi {
    public final CakeService cakeService;

    @Autowired
    public CakeControllerApi(CakeService cakeService) {
        this.cakeService = cakeService;
    }


    @GetMapping("/{id}")
    public Cake getById(@PathVariable("id") @Valid Long id) {
        return cakeService.findCakesById(id);
    }


    @GetMapping
    public List<Cake> getAll() {
        return cakeService.findAll();
    }


    @PostMapping
    public void saveCake(@ModelAttribute @Valid CakeDto cake) {
        cakeService.saveCake(cake);
    }

    @PutMapping("/{id}")
    public void update(
            @RequestBody @Valid CakeDto cake,
            @PathVariable("id") Long id
    ) {
        cakeService.updateCake(cake, id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        cakeService.deleteCake(id);
    }
}
