package com.example.dashboard_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class more_pg extends AppCompatActivity {
    private LinearLayout fbpage;
    private Button UrlOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_pg);

        UrlOpen = (Button)findViewById(R.id.button1);

        UrlOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu"));
                startActivity(Getintent);

            }
        });


        UrlOpen = (Button)findViewById(R.id.button2);

        UrlOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://g.co/kgs/9JAerN"));
                startActivity(Getintent);

            }
        });

        {
            fbpage = findViewById(R.id.fbpage);

            fbpage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(more_pg.this, feedbackform.class);
                    startActivity(intent);
                }
            });
        }
    }
}