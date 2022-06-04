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
public class Cake {

    @NotNull(message = "id не может быть пустым")
    private UUID id;

    @NotBlank(message = "Название торта не может быть пустым")
    private  String name;

    @NotBlank(message = "Описание торта не может быть пустым")
    private  String description;


    @NotNull(message = "Цена не может быть пустым")
    private Integer price;



}
