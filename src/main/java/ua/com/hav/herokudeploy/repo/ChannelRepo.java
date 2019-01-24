package ua.com.hav.herokudeploy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.hav.herokudeploy.model.Channel;

public interface ChannelRepo extends JpaRepository<Channel, Long> {
}
