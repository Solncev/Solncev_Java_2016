package com.solncev.repositories;

import com.solncev.entities.News;

/**
 * Created by Марат on 25.11.2016.
 */
public interface NewsRepository {
    void update(long id, News news);

    int getCountByAuthorId(long id);
}
