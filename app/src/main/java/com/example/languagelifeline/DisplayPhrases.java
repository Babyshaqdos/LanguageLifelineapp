package com.example.languagelifeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DisplayPhrases extends AppCompatActivity implements PhraseUI {

    private RecyclerView recyclerViewPhrases;
    private ScrollingAdapter scrollingAdapter;
    private GridLayout gridLayoutRight;
    public List<String> phrases;
    public String currentLanguage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_layout);
        phrases = new ArrayList<>();

        englishPhrases engPhrase = new englishPhrases();
        frenchPhrases frenchPhrases = new frenchPhrases();
        spanishPhrases spanishPhrases = new spanishPhrases();

        Intent receivingIntent = getIntent(); //The getIntent() method will grab the last intent that was passed into this class and assign it to our new intent
       /* String variable1 = receivingIntent.getStringExtra("FirstVariableStringValue"); //The name must exactly match the name you gave it in the prior class or else it wont find the value
        Integer variable2 = receivingIntent.getIntExtra("SecondVariableIntValue", 0); //Same functionality as line above but showing how you can get different data types from the same intent
        */




        //Get the current language to populate the phrases/buttons
        currentLanguage = receivingIntent.getStringExtra("Language");

        switch(currentLanguage){
            case "English":
                phrases = engPhrase.getEnglishPhrases();
                break;
            case "French":
                phrases = frenchPhrases.getFrenchPhrases();
                break;
            case "Spanish":
                phrases = spanishPhrases.getSpanishPhrases();
                break;
            default:
                phrases = engPhrase.getEnglishPhrases();
        }


        //Set a layout manager for the recycler view and populate the view with the phrases
        recyclerViewPhrases = findViewById(R.id.phraseRecycler);
        recyclerViewPhrases.setHasFixedSize(true);
        recyclerViewPhrases.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewPhrases.setLayoutManager(linearLayoutManager);
        scrollingAdapter = new ScrollingAdapter(this, phrases);
        recyclerViewPhrases.setAdapter(scrollingAdapter);
        
        Button homeBtn = (Button)findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public String getLanguage(String language) {
        //Intent information can be retrieved here if we call getLanguage from the onCreate method, helpful for clarity of program
        String currLang = language;
        return currLang;
    }

    @Override
    public void setLanguage(String language) {

    }

    @Override
    public void getPhrasePictures(String url) {

    }

    @Override
    public void setPhrasePictures() {

    }

    @Override
    public void getAudioFiles(String url) {

    }

    @Override
    public void setAudioFiles() {

    }
}