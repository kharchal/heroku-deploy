package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Outcome;

public interface OutcomeRepo extends JpaRepository<Outcome, Long> {
}
