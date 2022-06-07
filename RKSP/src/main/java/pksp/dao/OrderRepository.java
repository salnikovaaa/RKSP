package pksp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pksp.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
