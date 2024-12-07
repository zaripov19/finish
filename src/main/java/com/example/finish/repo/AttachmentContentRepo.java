package com.example.finish.repo;

import com.example.finish.entity.AttachmentContent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import static com.example.finish.config.MyListener.EMF;

public class AttachmentContentRepo {

    public static AttachmentContent findbyAttachmentId(int attachmentId) {
        try (EntityManager em = EMF.createEntityManager()) {
            return em.createQuery("from AttachmentContent where attachment.id = :attachmentId", AttachmentContent.class)
                    .setParameter("attachmentId", attachmentId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Natija topilmasa null qaytarish
        } catch (Exception e) {
            throw new RuntimeException("Ma'lumotni olishda xatolik yuz berdi: " + e.getMessage(), e);
        }
    }
}
