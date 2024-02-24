package com.example.weatherbroadcast.JSON;

import com.example.weatherbroadcast.MainApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser {
    public static void parseJSON(String jsonResponse, String city, MainApp app) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            JSONObject weather = weatherArray.getJSONObject(0);

            JSONObject main = jsonObject.getJSONObject("main");

            double temperature = Math.round(main.getDouble("temp") - 273.15);

            double humidity = main.getDouble("humidity");

            JSONObject wind = jsonObject.getJSONObject("wind");
            double windSpeed = wind.getDouble("speed");

            String icon = weather.getString("icon");

            app.setCityText(city);
            app.setTempText((temperature) + "°");
            app.setHumidityText((humidity) + "%");
            app.setWindSpeedText((windSpeed) + "km/h");
            app.setWeatherImg(icon);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}