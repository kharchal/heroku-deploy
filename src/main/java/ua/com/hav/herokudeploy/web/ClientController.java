package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.service.ClientService;
import ua.com.hav.herokudeploy.service.EntityUpdateController;
import ua.com.hav.herokudeploy.service.LevelService;
import ua.com.hav.herokudeploy.service.StateService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ClientController {

    public static final String CLIENTS = "clients";
    public static final String REDIRECT_CLIENTS = "redirect:/clients";
    public static final String CLIENT_FORM = "client_form";

    private static Map<Long, String> levels = new HashMap<>();
    private static Map<Long, String> states = new HashMap<>();

    @Autowired
    private ClientService clientService;

    @Autowired
    private StateService stateService;

    @Autowired
    private LevelService levelService;

    @RequestMapping("/clients")
    public String list(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return CLIENTS;
    }

    @RequestMapping("/clients/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.findById(id));
        return CLIENT_FORM;
    }

    @RequestMapping("/clients/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return CLIENT_FORM;
    }

    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public String save(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return CLIENT_FORM;
        }
        clientService.save(client);
        return REDIRECT_CLIENTS;
    }

    @ModelAttribute("levels")
    public Map<Long, String> levelMap() {
        if (EntityUpdateController.levelsReload) {
            levels = levelService.map();
            EntityUpdateController.levelsReload = false;
        }
        return levels;
    }

    @ModelAttribute("states")
    public Map<Long, String> stateMap() {
        if (EntityUpdateController.statesReload) {
            states = stateService.map();
            EntityUpdateController.statesReload = false;
        }
        return states;
    }
}
