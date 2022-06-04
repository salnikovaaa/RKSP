package pksp.dao;

import org.apache.ibatis.annotations.*;
import pksp.models.Client;
import pksp.models.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Mapper
public interface OrderRepository {

    void saveOrder(Order order);

    List<Order> findAll();

    @Select("SELECT id, client_id, cake_id, count, total_price FROM orders WHERE id = #{id}::UUID")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "clientId", column = "client_id"),
            @Result(property = "cakeId", column = "cake_id"),
            @Result(property = "count", column = "count"),
            @Result(property = "totalPrice", column = "total_price")
    })
    Optional<Order> findById(UUID id);




    void updateOrder(Order order);

    void deleteOrder(UUID id);
}
