package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PracticeReport extends AppCompatActivity {
    TextView rof;
    TextView filler;
    String rateOfspeech;
    String fillerCount;
    //DatabaseHelper mDatabaseHelper;
    String res, res1;
    String str;
    private Note selectedNote;
    TextView text, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_report);
        getSupportActionBar().setTitle("Practice Report");
//        checkForEditNote();
//        final EditText input = findViewById(R.id.input);
//        final Button postButton =  findViewById(R.id.post);
        rof = findViewById(R.id.rateOfSpeech);
        filler = findViewById(R.id.fillerCount);
        output = findViewById(R.id.output);
        text = findViewById(R.id.text);
        RequestQueue queue = Volley.newRequestQueue(PracticeReport.this);
        String url = "https://sentiment-analysis-api.herokuapp.com/sentiment";
        str = getIntent().getStringExtra("string");
        rateOfspeech = getIntent().getStringExtra("rateOfSpeech");
        fillerCount = getIntent().getStringExtra("filler_count");
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                text.setText(String.format("%s : ", str));
                output.setText(response.toUpperCase());
                res1 = response.toUpperCase();
                //res = str + " Result: - "+res1+" Filler count: -"+fillerCount+" Rate of speech: - "+rateOfspeech;
                //AddData(res);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                output.setText(error.getMessage());
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("text", str);
                return new JSONObject(params2).toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        queue.add(sr);
        rof.setText(rateOfspeech);
        filler.setText(fillerCount);
    }
//    public void AddData(String newEntry) {
//        boolean insertData = mDatabaseHelper.addData(newEntry);
//        //boolean insertData = false;
//        if (insertData) {
//            toastMessage("Data Successfully Inserted!");
//        } else {
//            toastMessage("Something went wrong");
//        }
//    }
//    private void toastMessage(String message){
//        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
//    }
//    private void checkForEditNote()
//    {
//        Intent previousIntent = getIntent();
//
//        int passedNoteID = previousIntent.getIntExtra(Note.NOTE_EDIT_EXTRA, -1);
//        selectedNote = Note.getNoteForID(passedNoteID);
//
//        if (selectedNote != null)
//        {
//            text.setText(selectedNote.getStr());
//            output.setText(selectedNote.getResult());
//            filler.setText(selectedNote.getFillercount());
//            rof.setText(selectedNote.getRateofspeech());
//        }
//    }

    public void saveNote(View view)
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
//        String str1 = str;
//        String result = res;

        if(selectedNote == null)
        {
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, str, res1, fillerCount, rateOfspeech);
            Note.noteArrayList.add(newNote);
            sqLiteManager.addNoteToDatabase(newNote);
        }
        else
        {
            selectedNote.setStr(str);
            selectedNote.setResult(res1);
            selectedNote.setFillercount(fillerCount);
            selectedNote.setRateofspeech(rateOfspeech);
            sqLiteManager.updateNoteInDB(selectedNote);
        }

        finish();
    }
}