package com.solncev.service;

import com.solncev.model.User;

import java.util.List;

/**
 * Created by Марат on 13.03.2017.
 */
public interface UserService {

    void add(User user);

    List<User> getAll();

    User findOneByEmail(String email);

    User findOne(Long id);
}
