package com.example.finish.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class Filter extends HttpFilter {

    private List<String> openPaths = new ArrayList<>(
            List.of(
                    "/login.jsp",
                    "/auth/login",
                    "/register.jsp",
                    "/auth/register"
            )
    );

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (openPaths.contains(req.getRequestURI())) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = req.getSession();
        Object object = session.getAttribute("currentUser");
        if (object == null) {
            res.sendRedirect("/login.jsp");
            return;
        }
        chain.doFilter(req, res);
    }
}
