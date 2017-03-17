package com.solncev.controller;

import com.solncev.model.Message;
import com.solncev.model.User;
import com.solncev.service.MessageService;
import com.solncev.service.UserService;
import com.solncev.util.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Марат on 17.03.2017.
 */
@Controller
public class ChatController {
    private final MessageService messageService;
    private final UserService userService;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    @Autowired
    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @RequestMapping(value = "/chat")
    public String getChat(@RequestParam("id") Long id, Model model) {
        model.addAttribute("messages", messageService.findAllByRecipientId(id, ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
        model.addAttribute("messageForm", new MessageForm());
        model.addAttribute("interlocutor", id);
        return "chat";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String post(@ModelAttribute("messageForm") MessageForm messageForm, @RequestParam("id") Long id, Model model) {
        Message message = new Message();
        message.setText(messageForm.getText());
        message.setDate(format.format(new Date()));
        message.setSender((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        message.setRecipient(userService.findOne(id));
        messageService.add(message);
        return "redirect:/chat?id=" + id;
    }
}
