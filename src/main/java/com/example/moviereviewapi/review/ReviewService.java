package com.example.moviereviewapi.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review addReview(Review newReview) {
        return repository.save(newReview);
    }
}
