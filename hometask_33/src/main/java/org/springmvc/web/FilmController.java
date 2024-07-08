package org.springmvc.web;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView getFilmList () {
       ModelAndView model = new ModelAndView("film");
       var films = filmService.getAll();
       Genre[] values = Genre.values();
       model.addObject("films", films);
       model.addObject("genres", values);

       return model;
    }

    @PostMapping("/")
    public ModelAndView addFilm (@RequestParam("title") String title,
                           @RequestParam("description") String description,
                           @RequestParam("genre") Genre genre,
                           @RequestParam("year") Integer year,
                           @RequestParam(value = "viewed", required = false) String viewed
                           ) {
        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;
        Film film = new Film(title,description,genre,year,isViewed);
        filmService.add(film);

       ModelAndView modelAndView = new ModelAndView("redirect:/");

       return modelAndView;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") UUID uuid,
                       Model model) {

        Film film = filmService.getById(uuid);
        Genre[] values = Genre.values();
//        model.addAttribute("id", uuid);
        model.addAttribute("film", film);
        model.addAttribute("genres", values);

        return "edit";
    }
    @PostMapping("/edit")
    public ModelAndView update(@RequestParam(value ="title", required = false) String title,
                               @RequestParam(value ="description", required = false) String description,
                               @RequestParam(value ="genre",required = false) Genre genre,
                               @RequestParam(value ="year", required = false) Integer year,
                               @RequestParam(value = "viewed", required = false) String viewed,
                               @RequestParam("id") UUID uuid
                              ) {
        boolean isViewed = viewed == null || viewed.isBlank() ? false : true;
        Film film = new Film(title,description,genre,year,isViewed);
        filmService.update(uuid, film);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete (@RequestParam("id") UUID uuid) {
       filmService.delete(uuid);
       return "redirect:/";
    }

    @PostMapping("/search")
    public ModelAndView search (@RequestParam("search") String search) {

        List<Film> films;
        if (search == null || search.isBlank()){
            films = filmService.getAll();
        }else {
            films = filmService.find(search);
        }
        ModelAndView modelAndView = new ModelAndView("film");
        Genre[] values = Genre.values();
        modelAndView.addObject("films", films);
        modelAndView.addObject("genres", values);
        return  modelAndView;


    }
}

