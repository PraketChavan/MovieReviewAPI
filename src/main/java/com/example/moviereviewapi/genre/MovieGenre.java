package com.example.moviereviewapi.genre;

import com.example.moviereviewapi.movie.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class MovieGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_genre_movie"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Movie movieId;

    @Column(name = "genre_type")
    @Enumerated(value = EnumType.STRING)
    private GenreType genreType;

}
