package pksp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pksp.models.Cake;
import pksp.service.CakeService;
import pksp.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/cakes")
@RequiredArgsConstructor
public class CakeController {
    public final CakeService cakeService;

    @GetMapping
    public ModelAndView getAll(){
        List<Cake> cakes = cakeService.findAll();
        return new ModelAndView("catalog").addObject("cakes", cakes);
    }

    @GetMapping("/{id}")
    public Cake getById(@PathVariable("id") @Valid UUID id) {
        return cakeService.findCakesById(id);
    }
/*
    @GetMapping
    public List<Cake> getAll() {
        return cakeService.findAll();
    }
*/

    @PostMapping
    public void saveCake(@RequestBody @Valid Cake cake){
        cakeService.saveCake(cake);
    }

    @PutMapping
    public void update(@RequestBody @Valid Cake cake) {
        cakeService.updateCake(cake);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        cakeService.deleteCake(id);
    }
}
