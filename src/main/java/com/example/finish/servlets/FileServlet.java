package com.example.finish.servlets;

import com.example.finish.entity.AttachmentContent;
import com.example.finish.repo.AttachmentContentRepo;
import com.example.finish.repo.AttachmentRepo;

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
        int attachmentId = Integer.parseInt(req.getParameter("id"));
        AttachmentContent ac = AttachmentContentRepo.findbyAttachmentId(attachmentId);
        resp.getOutputStream().write(ac.getContent());
    }
}