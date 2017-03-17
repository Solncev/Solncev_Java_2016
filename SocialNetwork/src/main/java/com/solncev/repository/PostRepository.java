package com.solncev.repository;

import com.solncev.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Марат on 14.03.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByReceiverId(Long receiverId);
}
