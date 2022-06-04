package pksp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pksp.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Mapper
public interface ClientRepository {

    void saveClients(Client client);

    List<Client> findAll();

    @Select("SELECT id, name, email, phone_number FROM clients WHERE id = #{id}::UUID")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    Optional<Client> findById(UUID id);




    void updateClient(Client client);

    void deleteClient(UUID id);
}
