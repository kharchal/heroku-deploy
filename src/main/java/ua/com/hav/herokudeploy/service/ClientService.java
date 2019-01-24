package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Client;
import ua.com.hav.herokudeploy.model.State;
import ua.com.hav.herokudeploy.repo.ClientRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findById(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Client id = " + id));
    }

    @Transactional
    public void save(Client client) {
        clientRepo.save(client);
    }

    public Map<Long, String> map() {
        return clientRepo.findAll().stream().collect(Collectors.toMap(Client::getId, Client::getMnemo));
//        return clientRepo.findAll().stream().collect(Collectors.toMap(Client::getId, Client::getSurname));
    }
}
