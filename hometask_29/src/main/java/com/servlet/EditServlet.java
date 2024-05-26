package com.servlet;

import com.servlet.dto.Film;
import com.servlet.dto.Genre;
import com.servlet.service.FilmService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private FilmService service = new FilmService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID id = UUID.fromString(req.getParameter("id"));

        Film film = service.getById(id);

        req.setAttribute("film", film);
        req.setAttribute("genres", Genre.values());

        req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Genre genre = Genre.valueOf(req.getParameter("genre"));
        Integer year = Integer.valueOf(req.getParameter("year"));
        String viewed = req.getParameter("viewed");
        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;
        UUID id = UUID.fromString(req.getParameter("id"));

        Film film = new Film(title,description,genre,year,isViewed);

        service.update(id, film);

        resp.sendRedirect("/");
    }
}
