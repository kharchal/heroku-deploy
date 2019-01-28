package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Payment;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

    List<Payment> findAllByClientId(Long clientId);
}
