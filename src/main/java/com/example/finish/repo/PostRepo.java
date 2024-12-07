package com.example.finish.repo;

import com.example.finish.entity.Post;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

import static com.example.finish.config.MyListener.EMF;

public class PostRepo {
    public static List<Post> findAll() {
        try (EntityManager entityManager = EMF.createEntityManager()) {
            return entityManager.createQuery("from Post", Post.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Xatolik haqida ma'lumotni konsolga chiqarish
            return Collections.emptyList(); // Bo'sh ro'yxatni qaytarish
        }
    }
}
