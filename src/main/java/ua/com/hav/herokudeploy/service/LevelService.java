package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.herokudeploy.model.Level;
import ua.com.hav.herokudeploy.repo.LevelRepo;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LevelService {

    @Autowired
    private LevelRepo levelRepo;

    public Map<Long, String> map() {
        return levelRepo.findAll().stream().collect(Collectors.toMap(Level::getId, Level::getValue));
    }
}
