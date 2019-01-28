package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.model.Expense;
import ua.com.hav.herokudeploy.service.ClientService;
import ua.com.hav.herokudeploy.service.ExpenseService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ExpenseController {

    public static final String EXPENSES = "expenses";
    public static final String REDIRECT_EXPENSES = "redirect:/expenses";
    public static final String EXPENSE_FORM = "expense_form";

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/expenses")
    public String list(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return EXPENSES;
    }

    @RequestMapping("/expenses/new")
    public String newExpense(Model model) {
        model.addAttribute("expense", new Expense());
        return EXPENSE_FORM;
    }

    @RequestMapping("/expenses/new/{id}")
    public String newExpenseForClientId(@PathVariable Long id, Model model) {
        Expense expense = new Expense();
        Client client = clientService.findById(id);
        expense.setClient(client);
        model.addAttribute("expense", expense);
        model.addAttribute("mapping", "/clients/show/" + id);
        return EXPENSE_FORM;
    }

    @RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.findById(id));
        return EXPENSE_FORM;
    }

    @RequestMapping(value = "/expenses/save", method = RequestMethod.POST)
    public String save(@Valid Expense expense, BindingResult result, @RequestParam String mapping) {
        if (result.hasErrors()) {
            return EXPENSE_FORM;
        }
        expenseService.save(expense);
        return mapping.equals("") ? REDIRECT_EXPENSES : "redirect:" + mapping;
    }

    @ModelAttribute("clients")
    public Map<Long, String> clients() {
        return clientService.map();
    }
}
