package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
}
