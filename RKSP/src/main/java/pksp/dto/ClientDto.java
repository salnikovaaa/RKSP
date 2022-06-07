package pksp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientDto {
    @NotBlank(message = "Имя  не может быть пустым")
    private String name;

    @NotBlank(message = "email не может быть пустым")
    private String email;

    @NotNull(message = "Номер телефона не может быть пустым")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public ClientDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ClientDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
