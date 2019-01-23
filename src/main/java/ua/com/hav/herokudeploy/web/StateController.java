package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.State;
import ua.com.hav.herokudeploy.service.StateService;

import javax.validation.Valid;

@Controller
public class StateController {

    public static final String STATES = "states";
    public static final String REDIRECT_STATES = "redirect:/states";
    public static final String STATE_FORM = "state_form";

    @Autowired
    private StateService stateService;

    @RequestMapping("/states")
    public String list(Model model) {
        model.addAttribute("states", stateService.findAll());
        return STATES;
    }

    @RequestMapping("/states/new")
    public String newState(Model model) {
        model.addAttribute("state", new State());
        return STATE_FORM;
    }

    @RequestMapping("/states/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("state", stateService.findById(id));
        return STATE_FORM;
    }

    @RequestMapping(value = "/states/save", method = RequestMethod.POST)
    public String save(@Valid State state, BindingResult result) {
        if (result.hasErrors()) {
            return STATE_FORM;
        }
        stateService.save(state);
        return REDIRECT_STATES;
    }
}
