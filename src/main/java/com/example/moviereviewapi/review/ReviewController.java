package com.example.moviereviewapi.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/review/")
public class ReviewController {


    final ReviewService service;


    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(service.getAllReviews(), HttpStatus.OK);
    }



    @PostMapping("add")
    public ResponseEntity<Review> saveReview(@RequestBody Review newReview) {
        System.out.println(newReview);
        return new ResponseEntity<>(service.addReview(newReview), HttpStatus.CREATED);
    }
}
