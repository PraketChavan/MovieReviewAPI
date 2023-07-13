package com.example.moviereviewapi.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovieByImdbId(@PathVariable String imdbId) {
        Optional<Movie> movieFound = movieService.findMovieByImdbId(imdbId);
        return movieFound.map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
        System.out.println("Controller post captured");
        return new ResponseEntity<>(movieService.createMovie(newMovie),
                                    HttpStatus.CREATED);
    }

}
