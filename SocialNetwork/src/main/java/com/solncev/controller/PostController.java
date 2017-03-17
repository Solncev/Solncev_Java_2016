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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Марат on 15.03.2017.
 */
@Controller
public class PostController {
    private final PostService postService;
    private final UserService userService;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(@ModelAttribute("postForm") PostForm postForm, @RequestParam("id") Long id, Model model) {
        Post post = new Post();
        post.setText(postForm.getText());
        post.setDate(String.valueOf(format.format(new Date())));
        post.setAuthor((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        post.setReceiver(userService.findOne(id));
        if (!postForm.getText().equals("")) {
            postService.add(post);
        }
        return "redirect:/user?id=" + id;
    }


    @RequestMapping(value = "/repost")
    public String repost(@RequestParam("id") Long id, Model model) {
        Post newPost = new Post();
        Post post = postService.findOne(id);
        newPost.setReceiver((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        newPost.setAuthor(post.getAuthor());
        newPost.setDate(post.getDate());
        newPost.setText(post.getText());
        postService.add(newPost);
        return "redirect:/home";
    }
}
