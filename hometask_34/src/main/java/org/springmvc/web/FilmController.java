package org.springmvc.web;

import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springmvc.dto.Film;
import org.springmvc.dto.Genre;
import org.springmvc.service.FilmService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/")
@Data
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/")
//   @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getFilmList(@ModelAttribute(name = "filmmodel") Film film, Model model ) {

        var films = filmService.getAll();
        Genre[] values = Genre.values();
        model.addAttribute("films", films);
        model.addAttribute("genres", values);

        return "film";
    }

    @PostMapping("/")
    public String addFilm(@ModelAttribute(name = "filmmodel") @Valid Film film, BindingResult bindingResult,
                          @RequestParam(value = "viewed", required = false) String viewed,
                          Model model ) {
        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;
        String title = film.getTitle();
        String description = film.getDescription();
        Genre genre = film.getGenre();
        Integer year = film.getYear();
        film = new Film(title, description, genre, year, isViewed);
        if (!bindingResult.hasErrors()) { //избежал сохранения фильма с некорректными данными в базу данных
            filmService.add(film);
            return "redirect:/";          // выполнен перевод на начальную страницу(сначало делал через ссылку на странице)
        }
        var films = filmService.getAll();
        Genre[] values = Genre.values();
        model.addAttribute("films", films);
        model.addAttribute("genres", values);

        return "film";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute(name = "filmmodel") Film film,
                       @RequestParam("id") UUID uuid,
                       Model model) {

        film = filmService.getById(uuid);
        Genre[] values = Genre.values();
        model.addAttribute("film", film);
        model.addAttribute("genres", values);

        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute(name = "filmmodel") @Valid Film film, BindingResult bindingResult,
                         @RequestParam(value = "viewed", required = false) String viewed,
                         Model model ) {

        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;
        UUID uuid = film.getId();
        film.setIsViewed(isViewed);

        model.addAttribute("film", film);

        if (!bindingResult.hasErrors()) {  //избежал сохранения фильма с некорректными данными в базу данных
            filmService.update(uuid, film);
            return "redirect:/";           // выполнен перевод на начальную страницу
        }
        Genre[] values = Genre.values();
        model.addAttribute("genres", values);

        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") UUID uuid) {
        filmService.delete(uuid);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute(name = "filmmodel") Film film,
                         @RequestParam("search") String search,
                         Model model) {

        List<Film> films;
        if (search == null || search.isBlank()) {
            films = filmService.getAll();
        } else {
            films = filmService.find(search);
        }
        Genre[] values = Genre.values();
        model.addAttribute("films", films);
        model.addAttribute("genres", values);
        return "film";
    }
}

