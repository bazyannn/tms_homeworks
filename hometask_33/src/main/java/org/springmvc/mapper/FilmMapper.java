package org.springmvc.mapper;

import lombok.Data;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
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

    private final ObjectProvider<Film> filmObjectProvider;

    public Film map (ResultSet resultSet, boolean needNext) {

        Film object = filmObjectProvider.getObject();

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

            object.setId(id);
            object.setTitle(title);
            object.setDescription(description);
            object.setGenre(genre);
            object.setYear(year);
            object.setIsViewed(isViewed);

        } catch (SQLException e) {
            return null;
        }
        return object;

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
