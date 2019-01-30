package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.Channel;
import ua.com.hav.herokudeploy.model.Reason;
import ua.com.hav.herokudeploy.service.ChannelService;
import ua.com.hav.herokudeploy.service.ReasonService;

import javax.validation.Valid;

@Controller
public class ReasonController {

    public static final String LIST = "reasons";
    public static final String REDIRECT_LIST = "redirect:/" + LIST;
    public static final String FORM = "reason_form";

    @Autowired
    private ReasonService reasonService;

    @RequestMapping("/reasons")
    public String list(Model model) {
        model.addAttribute("reasons", reasonService.findAll());
        return LIST;
    }

    @RequestMapping("/reasons/new")
    public String newReason(Model model) {
        model.addAttribute("reason", new Reason());
        return FORM;
    }

    @RequestMapping("/reasons/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("reason", reasonService.findById(id));
        return FORM;
    }

    @RequestMapping(value = "/reasons/save", method = RequestMethod.POST)
    public String save(@Valid Reason reason, BindingResult result) {
        if (result.hasErrors()) {
            return FORM;
        }
        reasonService.save(reason);
        return REDIRECT_LIST;
    }
}
