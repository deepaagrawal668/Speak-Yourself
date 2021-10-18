package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Activity");

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    public void btn_practice(View view) {
        startActivity(new Intent(getApplicationContext(), practice.class));
    }
    public void btn_report(View view)
    {
        startActivity(new Intent(getApplicationContext(), Genral_Report.class));
    }

    public void btn_material(View view)
    {
        startActivity(new Intent(getApplicationContext(), Material.class));
    }

    public void btn_faq(View view)
    {
        startActivity(new Intent(getApplicationContext(), faq.class));
    }
}