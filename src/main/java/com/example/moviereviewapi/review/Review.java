package com.example.moviereviewapi.review;

import com.example.moviereviewapi.movie.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Reference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewbody")
    private String reviewBody;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movieId;

}
