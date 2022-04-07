package ru.job4j.serialization.json;

public class Film {

    private String movieName;

    public Film() {

    }

    public Film(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Film{"
                + "Movie name='" + movieName + '\''
                + '}';
    }
}