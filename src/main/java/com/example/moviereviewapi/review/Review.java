package com.example.moviereviewapi.review;

import com.example.moviereviewapi.movie.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_body", nullable = false)
    private String reviewBody;

    @Column(name = "date_posted", nullable = false)
    private Date datePosted;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", referencedColumnName = "imdb_id", foreignKey = @ForeignKey(name = "fk_review_movie"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Movie movieId;
}
