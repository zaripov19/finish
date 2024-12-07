package com.example.finish.servlets;

import com.example.finish.entity.AttachmentContent;
import com.example.finish.repo.AttachmentContentRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/file/get")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int attachmentId;
        try {
            attachmentId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Noto'g'ri ID qiymati.");
            return;
        }

        AttachmentContent ac = AttachmentContentRepo.findbyAttachmentId(attachmentId);
        if (ac == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Fayl topilmadi.");
            return;
        }

        // Faylni yuklash uchun javob sarlavhalarini sozlash
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"file_name\"");

        // Fayl kontentini yozish
        resp.getOutputStream().write(ac.getContent());
    }
}
