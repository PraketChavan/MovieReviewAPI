package com.example.moviereviewapi.movie;

import com.example.moviereviewapi.genre.GenreType;
import com.example.moviereviewapi.genre.MovieGenre;
import com.example.moviereviewapi.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imdb_id", unique = true, nullable = false, updatable = false)
    private String imdbId;

    @Column(nullable = false, updatable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @OneToMany(mappedBy = "movieId")
    private List<MovieGenre> genre;

    @Column(name = "trailer_link")
    private String trailerLink;

    @OneToMany(mappedBy = "movieId")
    private List<Review> review = new ArrayList<>();

}
