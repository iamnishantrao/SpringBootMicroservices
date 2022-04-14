package com.iamnishantrao.moviecatalogservice.models;

public class CatalogItem {

    private String movieTitle;
    private String movieDescription;
    private int movieRating;

    public CatalogItem(String movieTitle, String movieDescription, int movieRating) {
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.movieRating = movieRating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
