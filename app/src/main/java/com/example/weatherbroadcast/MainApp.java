package com.example.weatherbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.graphics.drawable.IconKt;

import android.graphics.drawable.Icon;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherbroadcast.UI.EditTextListener;
import com.squareup.picasso.Picasso;

public class MainApp extends AppCompatActivity {
    private EditText cityField;
    private TextView temp;
    private TextView city;
    private TextView humidity;
    private TextView windSpeed;
    private ImageView weatherImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityField = findViewById(R.id.cityField);
        cityField.addTextChangedListener(new EditTextListener(this));

        temp = findViewById(R.id.temp);
        city = findViewById(R.id.city);
        humidity = findViewById(R.id.humidity);
        windSpeed = findViewById(R.id.windspeed);
        weatherImg = findViewById(R.id.weatherImg);
    }

    public void setTempText(String temp) {
        this.temp.setText(temp);
    }

    public void setCityText(String city) {
        this.city.setText(city);
    }

    public void setHumidityText(String humidity) {
        this.humidity.setText(humidity);
    }

    public void setWindSpeedText(String windSpeed) {
        this.windSpeed.setText(windSpeed);
    }

    public void setWeatherImg(String img){
        String imageUrl = "https://openweathermap.org/img/wn/"+img+".png";

        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(weatherImg);
    }
}