package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.hav.herokudeploy.model.User;
import ua.com.hav.herokudeploy.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password, Model model, HttpSession session) {
        User loggedUser = userService.login(login, password);
        if (loggedUser == null) {
            model.addAttribute("msg", "Wrong credentials, try one more time");
            return "index";
        }
        if (!loggedUser.isActive()) {
            model.addAttribute("msg", "Your account is blocked, please connect with our admin");
            return "index";
        }
        session.setAttribute("loggedUser", loggedUser);
        return "/units";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("msg", "You are logged out successfully");
        return "index";
    }
}
