package com.solncev.service.impl;

import com.solncev.model.User;
import com.solncev.repository.UserRepository;
import com.solncev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Марат on 13.03.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

}
