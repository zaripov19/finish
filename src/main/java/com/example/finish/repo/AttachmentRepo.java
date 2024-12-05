package com.example.finish.repo;

import com.example.finish.entity.Attachment;
import com.example.finish.entity.AttachmentContent;
import jakarta.persistence.EntityManager;

import static com.example.finish.config.MyListener.EMF;

public class AttachmentRepo {
    public static Attachment saveFile(String submittedFileName, byte[] bytes) {
        try (EntityManager em = EMF.createEntityManager()) {
            Attachment attachment = new Attachment(
                    submittedFileName
            );
            AttachmentContent attachmentContent = new AttachmentContent(
                    attachment, bytes
            );
            em.getTransaction().begin();
            em.persist(attachment);
            em.persist(attachmentContent);
            em.getTransaction().commit();
            return attachment;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
