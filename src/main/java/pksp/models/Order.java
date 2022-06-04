package pksp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NotNull(message = "id заказа не может быть пустым")
    private UUID id;

    @NotNull(message = "id клиента не может быть пустым")
    private UUID clientId;

    @NotNull(message = "id торта не может быть пустым")
    private UUID cakeId;

    @Min(value = 1, message = "Количество должно быть больше 0")
    private Integer count;

    private Integer totalPrice;



}
