package com.example.languagelifeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class DisplayPhrases extends AppCompatActivity implements PhraseUI {

    private RecyclerView recyclerViewPhrases;
    private ScrollingAdapter scrollingAdapter;
    private GridLayout gridLayoutRight;
    public List<String> phrases;
    public String currentLanguage;
    public englishPhrases engPhrase;
    private frenchPhrases frenchPhrases;
    private spanishPhrases spanishPhrases;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        phrases = new ArrayList<>();

        engPhrase = new englishPhrases();
        frenchPhrases = new frenchPhrases();
        spanishPhrases = new spanishPhrases();

        Intent receivingIntent = getIntent();
        //The getIntent() method will grab the last intent that was passed into this class and assign it to our new intent
       /* String variable1 = receivingIntent.getStringExtra("FirstVariableStringValue"); //The name must exactly match the name you gave it in the prior class or else it wont find the value
        Integer variable2 = receivingIntent.getIntExtra("SecondVariableIntValue", 0); //Same functionality as line above but showing how you can get different data types from the same intent
        */

        //Get the current language to populate the phrases/buttons
        currentLanguage = receivingIntent.getStringExtra("Language");


        //Instantiate the button to send the user back to the home page to select a new language
        Button homeBtn = (Button)findViewById(R.id.homeBtn);

        //Set the listener for the button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the intent and send the user back to the Welcome class (home screen)
                Intent homeIntent = new Intent(view.getContext(), Welcome.class);
                startActivity(homeIntent);
            }
        });

        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup)findViewById(R.id.toggleGroup);
        int buttonToggle = materialButtonToggleGroup.getCheckedButtonId();
        MaterialButton patientBtn = materialButtonToggleGroup.findViewById(R.id.patientBtn);
        MaterialButton providerBtn = materialButtonToggleGroup.findViewById(R.id.providerBtn);

        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked){
                    if(checkedId == R.id.patientBtn){
                        //populate phrases with patients phrases
                        //Checks the valaue of currentLanguage and populates the phrases with the appropriate language, if no language selected or not recognizable enlgish is set as default
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

                    }
                    else if (checkedId == R.id.providerBtn){
                        //populate phrases with provider phrases
                        //Checks the valaue of currentLanguage and populates the phrases with the appropriate language, if no language selected or not recognizable enlgish is set as default
                        switch(currentLanguage){
                            case "English":
                                phrases = engPhrase.getProviderPhrases();
                                break;
                            case "French":
                                phrases = frenchPhrases.getProviderPhrases();
                                break;
                            case "Spanish":
                                phrases = spanishPhrases.getProviderPhrases();
                                break;
                            default:
                                phrases = engPhrase.getProviderPhrases();
                        }
                    }
                }
            }
        });


        //Set a layout manager for the recycler view and populate the view with the phrases
        recyclerViewPhrases = findViewById(R.id.phraseRecycler);
        recyclerViewPhrases.setHasFixedSize(true);
        recyclerViewPhrases.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewPhrases.setLayoutManager(linearLayoutManager);
        scrollingAdapter = new ScrollingAdapter(this, phrases);
        recyclerViewPhrases.setAdapter(scrollingAdapter);



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