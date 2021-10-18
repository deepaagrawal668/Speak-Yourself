package com.example.cardview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.os.SystemClock;
import android.widget.Chronometer;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class practice extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT =1000 ;
    private Chronometer chronometer;
    private boolean running;
    String str1;
    TextView mTextTv;
    TextView mCount;
    long time;
    int word;
    String wordCount;
    ImageButton mVoiceBtn;
    String FillerCOunt;
    Button btn;
    String time1;
    Button stopbtn;
    public int value;
    String word1;
    long rateOfSpeech;
    public String counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        getSupportActionBar().setTitle("Practice Section");

        mTextTv = findViewById(R.id.textTv);
        mVoiceBtn = findViewById(R.id.voicebtn);
        chronometer = findViewById(R.id.time);
        chronometer.setFormat("Time: %s");
        stopbtn = findViewById(R.id.stop);
        btn = findViewById(R.id.btn_report);
        btn.setEnabled(false);
        stopbtn.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(practice.this, PracticeReport.class);
                intent1.putExtra("string", str1);
                intent1.putExtra("rateOfSpeech", wordCount);
                intent1.putExtra("filler_count", FillerCOunt);
                intent1.putExtra("time", time1);
                intent1.putExtra("wordCount", word1);
                startActivity(intent1);
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running){
                    chronometer.stop();
                    running=false;
                    time = SystemClock.elapsedRealtime()-chronometer.getBase();
                    time1 = Long.toString(time);
                    rateOfSpeech = ((time)/(1000))-1;
                    rateOfSpeech = (word*60/rateOfSpeech);
                    word1 = Integer.toString(word);
                    wordCount = Long.toString(rateOfSpeech);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                }
            }
        });
        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }
    private void speak() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak Something");
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running=true;
        }
        try {
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if (resultCode==RESULT_OK && null!=data){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    mTextTv.setText(result.get(0));
                    str1 = result.get(0);
                    String str2[] =str1.split(" ");
                    int i=str2.length;
                    word = i;
                    counter = Integer.toString(i);
                    String[] filler = {"like","mean", "know", "anyway", "right","allright", "whatever", "what ever","what-ever", "so", "basically", "actually", "right", "ah", "uh","um"};
                    int count1=0;
                    for (int k=0;k<str2.length;k++)
                    {
                        for (int j=0;j<filler.length;j++)
                        {
                            if (str2[k].equals(filler[j]))
                            {
                                count1+=1;
                            }
                        }
                    }
                    FillerCOunt = Integer.toString(count1);
                    btn.setEnabled(true);
                    stopbtn.setEnabled(true);
                }
                break;
            }
        }
    }
}
