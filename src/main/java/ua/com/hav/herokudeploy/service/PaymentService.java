package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Payment;
import ua.com.hav.herokudeploy.repo.PaymentRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    public Payment findById(Long id) {
        return paymentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment id = " + id));
    }

    @Transactional
    public void save(Payment payment) {
        paymentRepo.save(payment);
    }
}
