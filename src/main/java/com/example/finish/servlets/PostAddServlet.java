package com.example.finish.servlets;

import com.example.finish.entity.Attachment;
import com.example.finish.entity.Post;
import com.example.finish.repo.AttachmentRepo;
import jakarta.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

import static com.example.finish.config.MyListener.EMF;

@MultipartConfig
@WebServlet("/post/add")
public class PostAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager entityManager = EMF.createEntityManager()) {
            Part cover = req.getPart("cover");
            Part audio = req.getPart("audio");
            Part video = req.getPart("video");
            String title = req.getParameter("title");

            try (InputStream coverStream = cover.getInputStream();
                 InputStream audioStream = audio.getInputStream();
                 InputStream videoStream = video.getInputStream()) {

                Attachment coverAttachment = AttachmentRepo.saveFile(cover.getSubmittedFileName(), coverStream.readAllBytes());
                Attachment audioAttachment = AttachmentRepo.saveFile(audio.getSubmittedFileName(), audioStream.readAllBytes());
                Attachment videoAttachment = AttachmentRepo.saveFile(video.getSubmittedFileName(), videoStream.readAllBytes());

                Post post = new Post(title, coverAttachment, audioAttachment, videoAttachment);
                entityManager.getTransaction().begin();
                entityManager.persist(post);
                entityManager.getTransaction().commit();
            }
            resp.sendRedirect("/post.jsp");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Xatolik yuz berdi. Iltimos, qayta urinib ko'ring.");
            e.printStackTrace();
        }
    }
}