package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.Payment;
import ua.com.hav.herokudeploy.service.ChannelService;
import ua.com.hav.herokudeploy.service.ClientService;
import ua.com.hav.herokudeploy.service.PaymentService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class PaymentController {

    public static final String PAYMENTS = "payments";
    public static final String REDIRECT_PAYMENTS = "redirect:/payments";
    public static final String PAYMENT_FORM = "payment_form";

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/payments")
    public String list(Model model) {
        model.addAttribute("payments", paymentService.findAll());
        return PAYMENTS;
    }

    @RequestMapping("/payments/new")
    public String newPayment(Model model) {
        model.addAttribute("payment", new Payment());
        return PAYMENT_FORM;
    }

    @RequestMapping("/payments/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("payment", paymentService.findById(id));
        return PAYMENT_FORM;
    }

    @RequestMapping(value = "/payments/save", method = RequestMethod.POST)
    public String save(@Valid Payment payment, BindingResult result) {
        if (result.hasErrors()) {
            return PAYMENT_FORM;
        }
        paymentService.save(payment);
        return REDIRECT_PAYMENTS;
    }

    @ModelAttribute("clients")
    public Map<Long, String> clients() {
        return clientService.map();
    }

    @ModelAttribute("channels")
    public Map<Long, String> channels() {
        return channelService.map();
    }
}
