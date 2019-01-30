package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Outcome;
import ua.com.hav.herokudeploy.repo.OutcomeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OutcomeService {

    @Autowired
    private OutcomeRepo outcomeRepo;

    public List<Outcome> findAll() {
        return outcomeRepo.findAll(new Sort(Sort.Direction.ASC, "date"));
    }

    public Outcome findById(Long id) {
        return outcomeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Outcome id = " + id));
    }

    @Transactional
    public void save(Outcome outcome) {
        outcomeRepo.save(outcome);
    }
}
