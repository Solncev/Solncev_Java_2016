package com.solncev.repositories;

import com.solncev.entities.Community;

/**
 * Created by Марат on 25.11.2016.
 */
public interface CommunityRepository {
    void update(long id, Community community);
}
