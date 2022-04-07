package ru.job4j.serialization.json;

import org.json.JSONObject;

public class MainCinema {
    public static void main(String[] args) throws Exception {
        Cinema cinema = new Cinema("Stan Lee", true,
                new Film("Spider-Man"), 90,
                new double[]{16.45, 18.00, 20.30});
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("FilmDirector", cinema.getFilmDirector());
        jsonObject.put("StartSession", cinema.isStartSession());
        jsonObject.put("Film", cinema.getFilm());
        jsonObject.put("Duration", cinema.getDuration());
        jsonObject.put("Schedule", cinema.getSchedule());

        System.out.println(jsonObject.toString());
    }

}
