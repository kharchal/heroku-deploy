package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.herokudeploy.model.Outcome;
import ua.com.hav.herokudeploy.service.ChannelService;
import ua.com.hav.herokudeploy.service.ClientService;
import ua.com.hav.herokudeploy.service.OutcomeService;
import ua.com.hav.herokudeploy.service.ReasonService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class OutcomeController {

    public static final String LIST = "outcomes";
    public static final String REDIRECT_LIST = "redirect:/outcomes";
    public static final String FORM = "outcome_form";

    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ReasonService reasonService;

    @RequestMapping("/outcomes")
    public String list(Model model) {
        model.addAttribute("outcomes", outcomeService.findAll());
        return LIST;
    }

    @RequestMapping("/outcomes/new")
    public String newOutcome(Model model) {
        model.addAttribute("outcome", new Outcome());
        return FORM;
    }

    @RequestMapping("/outcomes/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("outcome", outcomeService.findById(id));
        return FORM;
    }

    @RequestMapping(value = "/outcomes/save", method = RequestMethod.POST)
    public String save(@Valid Outcome outcome, BindingResult result) {
        if (result.hasErrors()) {
            return FORM;
        }
        outcomeService.save(outcome);
        return REDIRECT_LIST;
    }

    @ModelAttribute("clients")
    public Map<Long, String> clients() {
        return clientService.map();
    }

    @ModelAttribute("channels")
    public Map<Long, String> channels() {
        return channelService.map();
    }

    @ModelAttribute("reasons")
    public Map<Long, String> reasons() {
        return reasonService.map();
    }
}
