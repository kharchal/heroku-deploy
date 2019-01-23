package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Level;
import ua.com.hav.herokudeploy.repo.LevelRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LevelService {

    @Autowired
    private LevelRepo levelRepo;

    public Map<Long, String> map() {
        return levelRepo.findAll().stream().collect(Collectors.toMap(Level::getId, Level::getValue));
    }

    public List<Level> findAll() {
        return levelRepo.findAll();
    }

    public Level findById(Long id) {
        return levelRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Level id = " + id));
    }

    @Transactional
    public void save(Level level) {
        levelRepo.save(level);
    }
}
