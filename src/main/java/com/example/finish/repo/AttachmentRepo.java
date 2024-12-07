package com.example.finish.repo;

import com.example.finish.entity.Attachment;
import com.example.finish.entity.AttachmentContent;
import jakarta.persistence.EntityManager;

import static com.example.finish.config.MyListener.EMF;

public class AttachmentRepo {
    public static Attachment saveFile(String submittedFileName, byte[] bytes) {
        try (EntityManager em = EMF.createEntityManager()) {
            em.getTransaction().begin();
            try {
                Attachment attachment = new Attachment(submittedFileName);
                AttachmentContent attachmentContent = new AttachmentContent(attachment, bytes);
                em.persist(attachment);
                em.persist(attachmentContent);
                em.getTransaction().commit();
                return attachment;
            } catch (Exception e) {
                em.getTransaction().rollback(); // Tranzaksiyani bekor qilish
                throw new RuntimeException("Faylni saqlashda xatolik yuz berdi: " + e.getMessage(), e);
            }
        }
    }
}
