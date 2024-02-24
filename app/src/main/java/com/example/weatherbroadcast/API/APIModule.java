package com.example.weatherbroadcast.API;

import android.os.AsyncTask;
import android.util.Log;

import com.example.weatherbroadcast.JSON.Parser;
import com.example.weatherbroadcast.MainApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class APIModule extends AsyncTask<Void, Void, String>  {
    private String city;
    private MainApp app;

    public APIModule(String city, MainApp app) {
        this.city = city;
        this.app = app;
    }

    @Override
    public String doInBackground(Void... voids){

        String APIURL = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=1d363bc3816d0780818cf2deb3a3d536";

        try {
            URL url = new URL(APIURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }

                bufferedReader.close();

                Parser.parseJSON(response.toString(), city, app);

                Log.d("API Success", String.valueOf(responseCode));
                connection.disconnect();
                return response.toString();
            }else {
                Log.e("API Error", String.valueOf(responseCode));
                connection.disconnect();
                return "Error";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
