package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.model.Reason;
import ua.com.hav.herokudeploy.repo.ReasonRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReasonService {

    @Autowired
    private ReasonRepo reasonRepo;

    public List<Reason> findAll() {
        return reasonRepo.findAll();
    }

    public Reason findById(Long id) {
        return reasonRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Reason id = " + id));
    }

    @Transactional
    public void save(Reason reason) {
        reasonRepo.save(reason);
    }

    public Map<Long, String> map() {
        return findAll().stream().collect(Collectors.toMap(Reason::getId, Reason::getValue));
    }
}
