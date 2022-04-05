package ru.job4j.serialization.json;

public class Film {
    private final String movieName;

    public Film(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Film{"
                + "Movie name='" + movieName + '\''
                + '}';
    }
}

