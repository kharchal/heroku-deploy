package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.Level;
import ua.com.hav.herokudeploy.service.LevelService;

import javax.validation.Valid;

@Controller
public class LevelController {

    public static final String LEVELS = "levels";
    public static final String REDIRECT_LEVELS = "redirect:/levels";
    public static final String LEVEL_FORM = "level_form";

    @Autowired
    private LevelService levelService;

    @RequestMapping("/levels")
    public String list(Model model) {
        model.addAttribute("levels", levelService.findAll());
        return LEVELS;
    }

    @RequestMapping("/levels/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("level", levelService.findById(id));
        return LEVEL_FORM;
    }

    @RequestMapping("/levels/new")
    public String newLevel(Model model) {
        model.addAttribute("level", new Level());
        return LEVEL_FORM;
    }

    @RequestMapping(value = "/levels/save", method = RequestMethod.POST)
    public String save(@Valid Level level, BindingResult result) {
        if (result.hasErrors()) {
            return LEVEL_FORM;
        }
        levelService.save(level);
        return REDIRECT_LEVELS;
    }
}
