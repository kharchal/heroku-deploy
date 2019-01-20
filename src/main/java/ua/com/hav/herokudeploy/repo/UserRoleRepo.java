package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
