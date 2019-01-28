package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientBalanceService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private PaymentService paymentService;


}
