package com.example.chuong_6.ui.intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class intentViewModel extends ViewModel {
    private final MutableLiveData<String> text = new MutableLiveData<>();

    public intentViewModel() {
        text.setValue("Waiting for intent data...");
    }

    public LiveData<String> getText() {
        return text;
    }

    public void setText(String newText) {
        text.setValue(newText);
    }
}