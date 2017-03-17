package com.solncev.service;

import com.solncev.model.Post;

import java.util.List;

/**
 * Created by Марат on 14.03.2017.
 */
public interface PostService {
    void add(Post post);

    List<Post> findByReceiverId(Long receiverId);

    Post findOne(long id);
}
