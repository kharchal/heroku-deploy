package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Unit;
import ua.com.hav.herokudeploy.repo.UnitRepo;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
    public void clearAll() {
        unitRepo.deleteAll();
    }

    @Transactional
    public void update(Long id, Integer data) {
        Unit unit = unitRepo.findById(id).orElseThrow(() -> new RuntimeException());
        unit.setQty(data);
        unitRepo.save(unit);
    }

    @Transactional
    public void saveAll(List<Unit> list) {
        unitRepo.saveAll(list);
    }

    public List<Unit> list() {
        return unitRepo.findAll(new Sort(Sort.Order.asc("id")));
    }

    @Transactional
    public void delete(Long id) {
        unitRepo.deleteById(id);
    }

    public Unit findOne(Long id) {
        return unitRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("unit id = " + id));
    }

    @Transactional
    public void save(Unit unit) {
        unitRepo.save(unit);
    }
}
