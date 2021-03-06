package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.model.Expense;
import ua.com.hav.herokudeploy.model.Payment;
import ua.com.hav.herokudeploy.repo.PaymentRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ClientService clientService;

    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    public Payment findById(Long id) {
        return paymentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment id = " + id));
    }

    @Transactional
    public void save(Payment payment) {
        paymentRepo.save(payment);
        Long clientId = payment.getClient().getId();
        List<Payment> payments = paymentRepo.findAllByClientId(clientId);
        List<Expense> expenses = expenseService.findAllByClientId(clientId);
        int pSum = 0;
        for (Payment p : payments) {
            pSum += p.getAmount();
        }
        int eSum = 0;
        for (Expense e : expenses) {
            eSum += e.getAmount();
        }
        int balance = pSum - eSum;
        Client client = clientService.findById(clientId);
        client.setBalance(balance + client.getInitialBalance());
        clientService.save(client);
    }

    public List<Payment> findAllByClientId(Long id) {
        return paymentRepo.findAllByClientId(id);
    }
}
