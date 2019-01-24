package ua.com.hav.herokudeploy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.herokudeploy.model.Channel;
import ua.com.hav.herokudeploy.repo.ChannelRepo;
import ua.com.hav.herokudeploy.service.ChannelService;

import javax.validation.Valid;

@Controller
public class ChannelController {

    public static final String CHANNELS = "channels";
    public static final String REDIRECT_CHANNELS = "redirect:/channels";
    public static final String CHANNEL_FORM = "channel_form";

    @Autowired
    private ChannelService channelService;

    @RequestMapping("/channels")
    public String list(Model model) {
        model.addAttribute("channels", channelService.findAll());
        return CHANNELS;
    }

    @RequestMapping("/channels/new")
    public String newChannel(Model model) {
        model.addAttribute("channel", new Channel());
        return CHANNEL_FORM;
    }

    @RequestMapping("/channels/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("channel", channelService.findById(id));
        return CHANNEL_FORM;
    }

    @RequestMapping(value = "/channels/save", method = RequestMethod.POST)
    public String save(@Valid Channel channel, BindingResult result) {
        if (result.hasErrors()) {
            return CHANNEL_FORM;
        }
        channelService.save(channel);
        return REDIRECT_CHANNELS;
    }
}
