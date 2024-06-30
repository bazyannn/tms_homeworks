package org.springmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springmvc.dto.Film;
import org.springmvc.errors.YearException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final DataBaseService dataBaseService;

    public void add (Film film) {
        if (film.getYear() > 2025){
            throw new YearException("Have you invented a time machine???\n" +
                    "It's 2024 now. Please return to the page and enter the correct year the film was created.");
        }
        dataBaseService.add(film);
    }

    public List<Film> getAll() {
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
