package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Reason;

public interface ReasonRepo extends JpaRepository<Reason, Long> {
}
