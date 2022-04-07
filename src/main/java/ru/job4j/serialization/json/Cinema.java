package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

public class Cinema {

    private boolean startSession;

    private int duration;
    private Film film;
    private String filmDirector;

    private double[] schedule;

    public Cinema() {
    }

    public Cinema(String filmDirector, boolean startSession, Film film, int duration, double[] schedule) {
        this.filmDirector = filmDirector;
        this.startSession = startSession;
        this.film = film;
        this.duration = duration;
        this.schedule = schedule;
    }

    public boolean isStartSession() {
        return startSession;
    }

    public int getDuration() {
        return duration;
    }

    public Film getFilm() {
        return film;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public double[] getSchedule() {
        return schedule;
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
