package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "cinema")
@XmlAccessorType(XmlAccessType.FIELD)

public class Cinema {

    @XmlAttribute
    private boolean startSession;

    @XmlAttribute
    private int duration;
    private Film film;
    private String filmDirector;

    @XmlElementWrapper(name = "schedules")
    @XmlElement(name = "schedule")
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
