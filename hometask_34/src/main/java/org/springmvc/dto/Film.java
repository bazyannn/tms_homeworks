package org.springmvc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")

public class Film {

    private  UUID id;
    @NotEmpty(message = "this field cannot be empty")
    private  String title;
    private  String description;
    @NotNull(message = "genre must be chosen")
    private  Genre genre;
    @Min(value = 1895, message = "the year cannot be less than 1895")
    private  Integer year;
    private  Boolean isViewed;

    public Film(String title, String description, Genre genre, Integer year, Boolean isViewed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.isViewed = isViewed;
    }
}



