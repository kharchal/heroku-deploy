package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Client;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {
    List<Client> findByLevelId(Long id);
}
