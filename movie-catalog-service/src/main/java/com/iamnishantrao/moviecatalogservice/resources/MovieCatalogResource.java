package com.iamnishantrao.moviecatalogservice.resources;

import com.iamnishantrao.moviecatalogservice.models.CatalogItem;
import com.iamnishantrao.moviecatalogservice.models.Movie;
import com.iamnishantrao.moviecatalogservice.models.Rating;
import com.iamnishantrao.moviecatalogservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // get all rated movie IDs
        UserRating userRatings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users" + userId, UserRating.class);
        List<Rating> ratings = userRatings.getUserRating();

        return ratings.stream().map(rating -> {

            // for each movie ID, call movie info service and get the details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

            // put them all together
            return new CatalogItem(movie.getMovieTitle(), "desctiption", rating.getMovieRating());
        }).collect(Collectors.toList());

    }
}
