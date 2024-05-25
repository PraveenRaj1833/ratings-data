package com.example.controllers;

import com.example.models.Rating;
import com.example.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) throws InterruptedException {
        List<Rating> ratings = Arrays.asList(
                new Rating("Avengers", 5),
                new Rating("Memento", 4)
        );
//        Thread.sleep(5000);
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }

}
