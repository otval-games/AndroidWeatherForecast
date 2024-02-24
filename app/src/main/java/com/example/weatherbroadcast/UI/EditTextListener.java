package com.example.weatherbroadcast.UI;

import android.text.Editable;
import android.text.TextWatcher;

import com.example.weatherbroadcast.API.APIModule;
import com.example.weatherbroadcast.MainApp;
import com.google.android.gms.common.api.Api;

import java.util.Arrays;

public class EditTextListener implements TextWatcher {
    private MainApp app;

    public EditTextListener(MainApp app) {
        this.app = app;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!(String.valueOf(s).equals(""))) {
            new APIModule(String.valueOf(s), app).execute();
        }
    }
}
