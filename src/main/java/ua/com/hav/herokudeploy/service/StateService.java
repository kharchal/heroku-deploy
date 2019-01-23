package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.State;
import ua.com.hav.herokudeploy.repo.StateRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepo stateRepo;

    public Map<Long, String> map() {
        return stateRepo.findAll().stream().collect(Collectors.toMap(State::getId, State::getValue));
    }

    public List<State> findAll() {
        return stateRepo.findAll();
    }

    public State findById(Long id) {
        return stateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("State id = " + id));
    }

    @Transactional
    public void save(State state) {
        stateRepo.save(state);
    }
}
