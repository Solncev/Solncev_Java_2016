package com.solncev.repositories;

import com.solncev.entities.User;

import java.util.List;

/**
 * Created by Марат on 25.11.2016.
 */
public interface UserRepository {
    void add(User user);

    List<User> getReceivedHighestNumberOfMessage(String season);

    List<User> getRespondedHighestNumberOfRequest(String text);
}
