package pksp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDto {
    @NotBlank(message = "Имя  не может быть пустым")
    private String name;

    @NotBlank(message = "email не может быть пустым")
    private String email;

    private Long cakeId;

    @NotNull(message = "Номер телефона не может быть пустым")
    @Column(unique=true)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public OrderDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Long getCakeId() {
        return cakeId;
    }

    public OrderDto setCakeId(Long cakeId) {
        this.cakeId = cakeId;
        return this;
    }
}
