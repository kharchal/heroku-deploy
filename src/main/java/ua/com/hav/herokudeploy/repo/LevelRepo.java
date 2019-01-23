package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Level;

public interface LevelRepo extends JpaRepository<Level, Long> {
}
