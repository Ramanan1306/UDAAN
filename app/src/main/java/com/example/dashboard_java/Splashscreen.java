package com.example.dashboard_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {
@Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    startActivity(new Intent(this,MainActivity.class));
    finish();
}
}
