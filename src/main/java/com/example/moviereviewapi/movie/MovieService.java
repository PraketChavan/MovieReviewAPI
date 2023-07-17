package com.example.moviereviewapi.movie;

import com.example.moviereviewapi.exception.MovieAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public Movie createMovie(Movie newMovie) {
        Optional<Movie> movieByImdbID = repository.findMovieByImdbId(
                newMovie.getImdbId());
        if (movieByImdbID.isPresent()) {
            throw new MovieAlreadyExistsException(
                    "The movie with IMDB ID:" + newMovie.getImdbId() + " already exists");
        }
        return repository.save(newMovie);
    }

    public List<Movie> createAllMovie(List<Movie> newMovies) {
        return repository.saveAll(newMovies);
    }
}
