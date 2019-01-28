package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.model.Expense;
import ua.com.hav.herokudeploy.model.Payment;
import ua.com.hav.herokudeploy.repo.ExpenseRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ClientService clientService;

    public List<Expense> findAll() {
        return expenseRepo.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense id = " + id));
    }

    @Transactional
    public void save(Expense expense) {
        expenseRepo.save(expense);
        Long clientId = expense.getClient().getId();
        List<Payment> payments = paymentService.findAllByClientId(clientId);
        List<Expense> expenses = expenseRepo.findAllByClientId(clientId);
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

    public List<Expense> findAllByClientId(Long id) {
        return expenseRepo.findAllByClientId(id);
    }
}
