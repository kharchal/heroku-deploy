package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.herokudeploy.model.User;
import ua.com.hav.herokudeploy.model.UserRole;
import ua.com.hav.herokudeploy.repo.UserRepo;
import ua.com.hav.herokudeploy.service.UserRoleService;
import ua.com.hav.herokudeploy.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

@Controller
public class UserController {

    public static final String USERS = "users";
    public static final String REDIRECT_USERS = "redirect:/users";
    public static final String USER_FORM = "user_form";

    public static Map<Long, UserRole> userRoles;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return USERS;
    }

    @RequestMapping("/users/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return USER_FORM;
    }

    @RequestMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return USER_FORM;
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult result) {
//        System.out.println("user = " + user);
//        System.out.println("roleIds = " + Arrays.toString(roleIds));
        if (result.hasErrors()) {
            return USER_FORM;
        }
        userService.save(user);
        return REDIRECT_USERS;
    }

    @ModelAttribute("roles")
    public Map<Long, UserRole> roles() {
        if (userRoles == null) {
            userRoles = userRoleService.roleMap();
        }
        return userRoles;
    }
}
