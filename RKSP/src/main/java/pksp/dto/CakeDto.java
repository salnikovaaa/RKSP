package pksp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CakeDto {
    private Long id;

    @NotBlank(message = "Название торта не может быть пустым")
    private String name;

    @NotBlank(message = "Описание торта не может быть пустым")
    private String description;

    private String compound;
    @NotNull(message = "Цена не может быть пустым")
    private Integer price;

    private String image;

    public Long getId() {
        return id;
    }

    public CakeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CakeDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public CakeDto setImage(String image) {
        this.image = image;
        return this;
    }

    public String getCompound() {
        return compound;
    }

    public CakeDto setCompound(String compound) {
        this.compound = compound;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CakeDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CakeDto setPrice(Integer price) {
        this.price = price;
        return this;
    }
}
