package ua.com.hav.herokudeploy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
//        model.addAttribute("msg", "some message");
        return "index";
    }

    @RequestMapping("/forbidden")
    public String forbidden(Model model) {
        model.addAttribute("msg", "Sorry, you are not allowed to access this page!");
        return "error";
    }
}
