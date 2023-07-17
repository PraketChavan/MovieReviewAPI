package com.example.moviereviewapi.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie/")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("{imdbId}")
    public ResponseEntity<Movie> getMovieByImdbId(@PathVariable String imdbId) {
        Optional<Movie> movieFound = movieService.findMovieByImdbId(imdbId);
        return movieFound.map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        return new ResponseEntity<>(movieService.createMovie(newMovie),
                                    HttpStatus.CREATED);
    }

    @PostMapping("addall")
    public ResponseEntity<List<Movie>> addAllMovie(@RequestBody List<Movie> newMovies) {
        return new ResponseEntity<>(movieService.createAllMovie(newMovies), HttpStatus.CREATED);
    }

}
