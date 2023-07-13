package com.example.moviereviewapi.movie;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
