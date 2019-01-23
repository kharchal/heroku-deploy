package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.herokudeploy.model.State;
import ua.com.hav.herokudeploy.repo.StateRepo;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepo stateRepo;

    public Map<Long, String> map() {
        return stateRepo.findAll().stream().collect(Collectors.toMap(State::getId, State::getValue));
    }
}
