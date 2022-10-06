package pksp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pksp.models.Cake;
@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {
}
