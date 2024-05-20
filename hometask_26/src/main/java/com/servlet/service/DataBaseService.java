package com.servlet.service;


import com.servlet.dto.Film;
import com.servlet.dto.Genre;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



public class DataBaseService {

    private static List<Film> films = new ArrayList<>();

    static {
        films.add(new Film("King kong","description1", Genre.ACTION,2005, true ));
        films.add(new Film("Ace Ventura","description2", Genre.COMEDY,2000, false ));
    }

    public void add (Film film){
        films.add(film);
    }

    public List<Film> getAll () {
        return films;
    }

    public Film getById (UUID id) {

        var find =films.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst();
        return find
                .orElseThrow(() -> new RuntimeException("film not found"));

    }


    public void update(UUID id, Film film) {
        for (var item : films){
            if(item.getId().equals(id)){
                item.setTitle(film.getTitle());
                item.setDescription(film.getDescription());
                item.setGenre(film.getGenre());
                item.setYear(film.getYear());
                item.setIsViewed(film.getIsViewed());

            }
        }
    }

    public void delete(UUID id) {
        Film byId = getById(id);
        films.remove(byId);
    }
// поиск для себя(без учёта регистра)
    public List<Film> find(String search) {
        return films.stream()
                .filter(film -> film.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }
}
