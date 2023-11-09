package com.app.repositories;

import com.app.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o WHERE o.email = ?1 AND o.id = ?2")
	Order findOrderByEmailAndOrderId(String email, Long cartId);

	List<Order> findAllByEmail(String emailId);
	
}
