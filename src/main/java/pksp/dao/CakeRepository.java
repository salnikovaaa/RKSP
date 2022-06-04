package pksp.dao;


import org.apache.ibatis.annotations.*;
import pksp.models.Cake;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface CakeRepository {

    void saveCakes(Cake cake);

    List<Cake> findAll();

    @Select("SELECT id, name, description,price FROM cakes WHERE id = #{id}::UUID")
    @Results(value = {
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "id", column = "id"),
            @Result(property = "price", column = "price")

    })
    Optional<Cake> findCakesById(UUID id);





    void updateCakes(Cake cake);

    void deleteCakes(UUID id);
}
