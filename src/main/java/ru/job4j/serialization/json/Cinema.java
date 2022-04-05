package ru.job4j.serialization.json;

import java.util.Arrays;

public class Cinema {

    private final String filmDirector;
    private final boolean startSession;
    private final Film film;
    private final int duration;
    private final double[] schedule;

    public Cinema(String filmDirector, boolean startSession, Film film, int duration, double[] schedule) {
        this.filmDirector = filmDirector;
        this.startSession = startSession;
        this.film = film;
        this.duration = duration;
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Cinema{"
                + "filmDirector='" + filmDirector + '\''
                + ", startSession=" + startSession
                + ", film=" + film
                + ", duration=" + duration
                + ", schedule=" + Arrays.toString(schedule)
                + '}';
    }
}
