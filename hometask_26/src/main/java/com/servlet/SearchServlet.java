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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private FilmService service = new FilmService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> films;
        String search = req.getParameter("search");
        if (search == null || search.isBlank()){
            films = service.getAll();
        }else {
            films = service.find(search);
        }
        req.setAttribute("films", films);
        req.setAttribute("genres", Genre.values());
        req.getRequestDispatcher("/WEB-INF/films.jsp").forward(req,resp);
    }


}
