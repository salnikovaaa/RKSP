package pksp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @NotNull(message = "id не может быть пустым")
    private UUID id;

    @NotBlank(message = "Имя  не может быть пустым")
    private  String name;

    @NotBlank(message = "email не может быть пустым")
    private  String email;


    @NotNull(message = "Номер телефона не может быть пустым")
    private String phoneNumber;



}
