package com.solncev.controller;

import com.solncev.model.Post;
import com.solncev.model.User;
import com.solncev.service.PostService;
import com.solncev.service.UserService;
import com.solncev.util.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

/**
 * Created by Марат on 13.03.2017.
 */
@Controller
public class MainController {
    private final UserService userService;
    private final PostService postService;

    @Autowired
    public MainController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.findByReceiverId(user.getId());
        if (posts != null) {
            model.addAttribute("posts", posts);
        }
        model.addAttribute("user", user);
        model.addAttribute("postForm", new PostForm());
        return "home";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/user")
    public String user(@RequestParam(name = "id") Long id, Model model) {
        if (Objects.equals(id, ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()))
            return "redirect:/home";
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        List<Post> posts = postService.findByReceiverId(user.getId());
        if (posts != null) {
            model.addAttribute("posts", posts);
        }
        model.addAttribute("user", user);
        model.addAttribute("postForm", new PostForm());
        return "user";
    }
}
