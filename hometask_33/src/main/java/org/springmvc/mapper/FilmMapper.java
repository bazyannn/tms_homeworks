package org.springmvc.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springmvc.dto.Film;
import org.springmvc.dto.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Data
public class FilmMapper {

    private final Film film;

    public Film map (ResultSet resultSet, boolean needNext) {

        Film film = new Film();

        try {
            if (needNext){
                resultSet.next();
            }
            UUID id = resultSet.getObject("id", UUID.class);
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            int year = resultSet.getInt("year");
            boolean isViewed = resultSet.getBoolean("is_viewed");

            film.setId(id);
            film.setTitle(title);
            film.setDescription(description);
            film.setGenre(genre);
            film.setYear(year);
            film.setIsViewed(isViewed);

        } catch (SQLException e) {
            return null;
        }
        return film;

    }

    public List<Film> maps (ResultSet resultSet){

        List<Film> films = new ArrayList<>();

        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Film film = map(resultSet, false);
            if (film != null){
                films.add(film);
            }
        }
        return films;

    }
}
