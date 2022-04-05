package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Cinema cinema = new Cinema("Stan Lee", true,
                new Film("Spider-Man"), 90,
                new double[]{16.45, 18.00, 20.30});

        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(cinema));

        final String cinemaJson = ""
                + "{\n"
                + "\"filmDirector\":\"Timothy Burton\",\n"
                + "\"startSession\":false,\n"
                + "\"film\":\n"
                + "{\n"
                + "\"movieName\":\"The Batman\"\n"
                + "},\n"
                + "\"duration\":124,\n"
                + "\"schedule\":[20.15,21.30,22.40]\n"
                + "}";

        final Cinema cinemaMod = gson.fromJson(cinemaJson, Cinema.class);
        System.out.println(cinemaJson);
    }
}
