package com.servlet;

import com.servlet.service.FilmService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private FilmService service = new FilmService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        service.delete(id);

        resp.sendRedirect("/");
    }
}
