package pksp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pksp.dto.CakeDto;
import pksp.models.Cake;
import pksp.service.CakeService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cakes")
public class CakeController {
    private final CakeService cakeService;

    @Autowired
    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping
    public ModelAndView getAll() {
        List<CakeDto> cakes = cakeService.findAll()
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());

        return new ModelAndView("cakes").addObject("cakes", cakes);
    }


    @GetMapping("{id}")
    public ModelAndView getCake(@PathVariable("id") Long id) {
        CakeDto cake = convertToDto(cakeService.findCakesById(id));
        return new ModelAndView("cakeInfo").addObject("cake", cake);
    }


    private CakeDto convertToDto(Cake cake) {

        return new CakeDto()
                .setName(cake.getName())
                .setDescription(cake.getDescription())
                .setCompound(cake.getCompound())
                .setPrice(cake.getPrice())
                .setId(cake.getId())
                .setImage(cake.getImage());
    }

}
