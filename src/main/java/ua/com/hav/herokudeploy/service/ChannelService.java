package ua.com.hav.herokudeploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.hav.herokudeploy.model.Channel;
import ua.com.hav.herokudeploy.repo.ChannelRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepo channelRepo;

    public List<Channel> findAll() {
        return channelRepo.findAll();
    }

    public Channel findById(Long id) {
        return channelRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Channel id = " + id));
    }

    @Transactional
    public void save(Channel channel) {
        channelRepo.save(channel);
    }

    public Map<Long, String> map() {
        return findAll().stream().collect(Collectors.toMap(Channel::getId, Channel::getValue));
    }
}
