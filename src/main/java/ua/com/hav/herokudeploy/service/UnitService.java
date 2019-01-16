package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Unit;
import ua.com.hav.herokudeploy.repo.UnitRepo;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepo unitRepo;

    @Transactional
    public void saveAlExceptional(List<Unit> list) {
        for (Unit unit : list) {
            if (unit.getQty() == 200) {
                throw new RuntimeException("~~~~~~~~~~");
            }
            unitRepo.save(unit);
        }
//        unitRepo.saveAll(list);
    }

    public void saveAll(List<Unit> list) {
        unitRepo.saveAll(list);
    }

    public List<Unit> list() {
        return unitRepo.findAll();
    }
}
