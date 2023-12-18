package com.Denyse.Final.Project.repository;

import com.Denyse.Final.Project.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepo extends JpaRepository<Payment, UUID> {

//    @Modifying
//    @Query("UPDATE CustomerOrder co SET co.paid = 'PAID' WHERE co.id = :orderId")
//    void handleSuccessfulPayment(UUID orderId);
}
