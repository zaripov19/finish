package com.example.finish.repo;

import com.example.finish.entity.Attachment;
import com.example.finish.entity.AttachmentContent;
import jakarta.persistence.EntityManager;

import static com.example.finish.config.MyListener.EMF;

public class AttachmentContentRepo {

    public static AttachmentContent findbyAttachmentId(int attachmentId) {
        try (EntityManager em = EMF.createEntityManager()) {
            return em.createQuery("from AttachmentContent  where attachment.id = :attachmentId", AttachmentContent.class)
                    .setParameter("attachmentId", attachmentId)
                    .getSingleResult();
        }
    }
}
