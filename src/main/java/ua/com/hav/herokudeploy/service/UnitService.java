package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Unit;
import ua.com.hav.herokudeploy.repo.UnitRepo;

import java.util.List;
import java.util.Optional;

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

    public void clearAll() {
        unitRepo.deleteAll();
    }

    public void update(Long id, Integer data) {
        Unit unit = unitRepo.findById(id).orElseThrow(() -> new RuntimeException());
        unit.setQty(data);
        unitRepo.save(unit);
    }

    public void saveAll(List<Unit> list) {
        unitRepo.saveAll(list);
    }

    public List<Unit> list() {
        return unitRepo.findAll(new Sort(Sort.Order.asc("id")));
    }
}
