package com.servlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Film {

    private UUID id;
    private String title;
    private String description;
    private Genre genre;
    private Integer year;
    private Boolean isViewed;

    public Film(String title, String description, Genre genre, Integer year, Boolean isViewed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
        this.isViewed = isViewed;
    }

}
