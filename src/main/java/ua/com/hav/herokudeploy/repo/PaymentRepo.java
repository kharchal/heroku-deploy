package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
