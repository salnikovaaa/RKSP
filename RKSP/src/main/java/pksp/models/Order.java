package pksp.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "id клиента не может быть пустым")
    @Column(name = "client_id", insertable = false, updatable = false)
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull(message = "id клиента не может быть пустым")
    @Column(name = "cake_id", insertable = false, updatable = false)
    private Long cakeId;

    @ManyToOne
    @JoinColumn(name = "cake_id")
    private Cake cake;

    @NotBlank(message = "Имя  не может быть пустым")
    private String name;

    @NotBlank(message = "email не может быть пустым")
    private String email;


    @NotNull(message = "Номер телефона не может быть пустым")
    @Column(unique=true)
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getClientId() {
        return clientId;
    }

    public Order setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }


    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Order setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public Order setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Order setClient(Client client) {
        this.client = client;
        return this;
    }

    public Long getCakeId() {
        return cakeId;
    }

    public Order setCakeId(Long cakeId) {
        this.cakeId = cakeId;
        return this;
    }

    public Cake getCake() {
        return cake;
    }

    public Order setCake(Cake cake) {
        this.cake = cake;
        return this;
    }
}
