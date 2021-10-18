package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Material extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        getSupportActionBar().setTitle("Material Section");
    }
    public void browse(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/fBnAMUkNM2k"));
        startActivity(browserIntent);
    }
    public void browse1(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/lHJ2w3KFpk4"));
        startActivity(browserIntent);
    }
    public void browse2(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/y9mRTos12Sw"));
        startActivity(browserIntent);
    }
    public void browse3(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/X8eoCv_krNM"));
        startActivity(browserIntent);
    }
    public void browse4(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/wwBDv3KN-7Y"));
        startActivity(browserIntent);
    }
    public void browse5(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/RmkMm2WMVN0"));
        startActivity(browserIntent);
    }
    public void browse6(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/X1M94vY-uS4"));
        startActivity(browserIntent);
    }
    public void browse7(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mERxUNtws5Q"));
        startActivity(browserIntent);
    }
    public void browse8(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/QGK7aTGHeIQ"));
        startActivity(browserIntent);
    }
    public void browse9(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/dKzl_82PbU4"));
        startActivity(browserIntent);
    }
    public void browse10(View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/U42WY3FFsk8"));
        startActivity(browserIntent);
    }
}