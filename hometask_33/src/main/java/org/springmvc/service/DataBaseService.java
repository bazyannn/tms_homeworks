package org.springmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springmvc.dto.Film;
import org.springmvc.mapper.FilmMapper;

import java.sql.*;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class DataBaseService {

    private final FilmMapper mapper;

    public void add (Film film){
        try ( Connection connection = getConnection()){

            var preparedStatement = connection
                    .prepareStatement("insert into films(id, title, description, genre, year, is_Viewed) VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, film.getId());
            preparedStatement.setString(2, film.getTitle());
            preparedStatement.setString(3, film.getDescription());
            preparedStatement.setString(4, film.getGenre().name());
            preparedStatement.setInt(5, film.getYear());
            preparedStatement.setBoolean(6 , film.getIsViewed());
            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public List<Film> getAll () {
        try (Connection connection = getConnection()){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from films order by title");
            return mapper.maps(resultSet);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Film getById (UUID id) {

        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from films where id = ?");
            preparedStatement.setObject(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Film film = mapper.map(resultSet,true);
            return film;

        }catch (Exception e){
            throw new RuntimeException();
        }
    }


    public void update(UUID id, Film film) {
        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("update films set title = ?, description = ?, genre = ?, year = ?, is_viewed = ? where id = ?");
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setString(3,film.getGenre().name());
            preparedStatement.setInt(4,film.getYear());
            preparedStatement.setBoolean(5,film.getIsViewed());
            preparedStatement.setObject(6,id);
            preparedStatement.execute();

        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void delete(UUID id) {
        try(Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("delete from films where id = ?");
            preparedStatement.setObject(1, id);
            preparedStatement.execute();

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public List<Film> find(String search) {
        try(Connection connection = getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from films where title ilike '%" + search + "%'");
            return mapper.maps(resultSet);

        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private Connection getConnection () {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/filmoteka?user=bazyan&password=z11411985z");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
