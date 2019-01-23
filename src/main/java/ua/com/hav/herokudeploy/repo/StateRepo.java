package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.State;

public interface StateRepo extends JpaRepository<State, Long> {
}
