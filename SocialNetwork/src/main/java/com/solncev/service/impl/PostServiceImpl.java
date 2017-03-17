package com.solncev.service.impl;

import com.solncev.model.Post;
import com.solncev.repository.PostRepository;
import com.solncev.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Марат on 14.03.2017.
 */
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findByReceiverId(Long receiverId) {
        return postRepository.findByReceiverId(receiverId);
    }

    @Override
    public Post findOne(long id) {
        return postRepository.findOne(id);
    }
}
