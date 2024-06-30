package com.servlet.service;

import com.servlet.dto.Film;

import java.util.List;
import java.util.UUID;

public class FilmService {

    private DataBaseService dataBaseService = new DataBaseService();

    public void add (Film film) {
        dataBaseService.add(film);
    }

    public List<Film>  getAll() {
        return dataBaseService.getAll();
    }

    public Film getById(UUID id) {
        return dataBaseService.getById(id);
    }

    public void update(UUID id, Film film) {
        dataBaseService.update(id,film);
    }

    public void delete(UUID id) {
        dataBaseService.delete(id);
    }

    public List<Film> find(String search) {
        return dataBaseService.find(search);
    }
}
