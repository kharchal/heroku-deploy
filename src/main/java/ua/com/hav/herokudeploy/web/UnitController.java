package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.hav.herokudeploy.model.Unit;
import ua.com.hav.herokudeploy.repo.UnitRepo;
import ua.com.hav.herokudeploy.service.UnitService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping("/units/populate/{n}")
    public String populate(@PathVariable Integer n) {
        List<Unit> units = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Unit unit = new Unit();
            unit.setName("name-" + i);
            unit.setQty(i * 100);
            units.add(unit);
        }
        if (n == 0) {
            unitService.saveAll(units);
        } else {
            unitService.saveAlExceptional(units);
        }
        return "redirect:/units";
    }

    @RequestMapping("/units")
    public String list(Model model, HttpSession session) {
        session.setAttribute("date" , new Date());
        model.addAttribute("units", unitService.list());
        return "units";
    }

    @RequestMapping("/units/clear")
    public String clear() {
        unitService.clearAll();
        return "redirect:/units";
    }

    @RequestMapping("/units/update/{id}")
    public String update(@PathVariable Long id) {
        unitService.update(id, LocalDateTime.now().getNano());
//        unitService.s
        return "redirect:/units";
    }
}
