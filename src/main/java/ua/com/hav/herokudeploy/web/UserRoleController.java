package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.UserRole;
import ua.com.hav.herokudeploy.service.UserRoleService;

import javax.validation.Valid;

@Controller
public class UserRoleController {

    public static final String ROLES = "roles";
    public static final String ROLE_FORM = "role_form";
    public static final String REDIRECT_ROLES = "redirect:/roles";

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/roles")
    public String list(Model model) {
        model.addAttribute("roles", userRoleService.findAll());
        return ROLES;
    }

    @RequestMapping(value = "/roles/save", method = RequestMethod.POST)
    public String save(@Valid UserRole userRole, BindingResult result) {
        if (result.hasErrors()) {
            return ROLE_FORM;
        }
        userRoleService.save(userRole);
        return REDIRECT_ROLES;
    }

    @RequestMapping("/roles/new")
    public String newUserRole(Model model) {
        model.addAttribute("role", new UserRole());
        return ROLE_FORM;
    }

    @RequestMapping("/roles/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("role", userRoleService.findById(id));
        return ROLE_FORM;
    }
}
