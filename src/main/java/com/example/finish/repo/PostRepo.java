package com.example.finish.repo;

import com.example.finish.entity.Post;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.example.finish.config.MyListener.EMF;

public class PostRepo {
    public static List<Post> findAll() {
        try(EntityManager entityManager = EMF.createEntityManager()) {
            return entityManager.createQuery("from Post", Post.class).getResultList();
        }
    }
}
