package pksp.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя  не может быть пустым")
    private String name;

    @NotBlank(message = "email не может быть пустым")
    private String email;


    @NotNull(message = "Номер телефона не может быть пустым")
    @Column(unique=true)
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private Set<Order> orders;


    public Long getId() {
        return id;
    }

    public Client setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Client setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Client setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

}
