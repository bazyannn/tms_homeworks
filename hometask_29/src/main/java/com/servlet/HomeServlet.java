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
@WebServlet("/")

public class HomeServlet extends HttpServlet {

    private FilmService filmService = new FilmService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var films = filmService.getAll();

        req.setAttribute("films", films);
        req.setAttribute("genres", Genre.values());

        req.getRequestDispatcher("/WEB-INF/films.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Genre genre = Genre.valueOf(req.getParameter("genre"));
        Integer year = Integer.valueOf(req.getParameter("year"));
        String viewed = req.getParameter("viewed");
        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;

        Film film = new Film(title,description,genre,year,isViewed);

        filmService.add(film);

        resp.sendRedirect("/");
    }
}

