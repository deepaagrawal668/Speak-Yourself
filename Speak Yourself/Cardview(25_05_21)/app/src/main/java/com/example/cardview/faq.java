package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class faq extends AppCompatActivity {
    //ExpandableTextView expandableTextView;
    //String longText=""
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        getSupportActionBar().setTitle("FAQ Section");
        //expandableTextView=(ExpandableTextView)findViewById(R.id.quest1);
        //expandableTextView.setText(longText);
    }

}