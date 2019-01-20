package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.herokudeploy.model.UserRole;
import ua.com.hav.herokudeploy.repo.UserRoleRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepo userRoleRepo;

    public List<UserRole> findAll() {
        return userRoleRepo.findAll();
    }

    public UserRole findById(Long id) {
        return userRoleRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("UserRole id = " + id));
    }

    public void save(UserRole userRole) {
        userRoleRepo.save(userRole);
    }

    public Map<Long, String> findAllRolesAsMap() {
        return findAll().stream().collect(Collectors.toMap(UserRole::getId, UserRole::getValue));
    }

    public Map<Long, UserRole> roleMap() {
        return findAll().stream().collect(Collectors.toMap(UserRole::getId, Function.identity()));
    }
}
