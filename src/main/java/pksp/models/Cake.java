package pksp.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название торта не может быть пустым")
    private String name;

    @NotBlank(message = "Описание торта не может быть пустым")
    private String description;

    private String compound;


    @NotNull(message = "Цена не может быть пустым")
    private Integer price;

    @OneToMany(mappedBy = "cake")
    private Set<Order> orders;

    private String image;

    public Long getId() {
        return id;
    }


    public Cake setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cake setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Cake setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Cake setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Cake setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public String getCompound() {
        return compound;
    }

    public Cake setCompound(String compound) {
        this.compound = compound;
        return this;
    }

    public Cake setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
