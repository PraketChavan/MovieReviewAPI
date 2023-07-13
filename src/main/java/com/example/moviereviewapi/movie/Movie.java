package com.example.moviereviewapi.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "movie")
public class Movie {

    @Id
    private Long id;

    @Column(name = "imdbid")
    private String imdbId;

    private String title;

    @Column(name = "releasedate")
    private String releaseDate;

    @Column(name = "trailerlink")
    private String trailerLink;

    public Movie(String imdbId, String title, String releaseDate, String trailerLink) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
    }
}
