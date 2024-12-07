package com.example.finish.servlets.auth;

import com.example.finish.entity.Users;
import jakarta.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.finish.config.MyListener.EMF;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        if (password.equals(passwordRepeat)) {
            Users user = new Users(
                    firstName,
                    lastName,
                    email,
                    password
            );
            try (EntityManager em = EMF.createEntityManager()) {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                resp.sendRedirect("/login.jsp");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect("/register.jsp");
        }
    }
}
