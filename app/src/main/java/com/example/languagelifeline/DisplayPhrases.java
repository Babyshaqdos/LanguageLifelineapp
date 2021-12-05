package com.example.languagelifeline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayPhrases extends AppCompatActivity implements PhraseUI {

    //Declare our variables and objects for local use in DisplayPhrases class
    private RecyclerView recyclerViewPhrases;
    private ScrollingAdapter scrollingAdapter;
    public List<String> phrases;
    public List<String> translatedPhrase;
    public String currentLanguage;
    public englishPhrases engPhrase;
    private frenchPhrases frenchPhrases;
    private spanishPhrases spanishPhrases;
    public String user;
    public TextView patientText;
    public TextView providerText;
    final Utils toasty = new Utils();
    private audioFiles audioFiles;
    public Map<String, Integer> audioMap;




    @Override //onCreate is called as soon as this activity is started
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main); //Set the layout
        //Instantiate our variables and objects for local use
        phrases = new ArrayList<>();
        user = "Patient";
        patientText = (TextView)findViewById(R.id.patientPhrase);
        providerText = (TextView)findViewById(R.id.providerPhrase);
        audioMap = new HashMap<>();
        engPhrase = new englishPhrases();
        frenchPhrases = new frenchPhrases();
        spanishPhrases = new spanishPhrases();
        translatedPhrase = engPhrase.getProviderPhrases();

        //Get our intent, used to send variable information between activities
        Intent receivingIntent = getIntent();

        //Get the current language to populate the phrases/buttons
        currentLanguage = receivingIntent.getStringExtra("Language");
        setLanguage(currentLanguage);
        try{ //Want to use a try catch here to handle any exceptions raised by receiving an empty intent, non empty intents are sent from scrolling adapter on the onclick
            String patientTranslation = receivingIntent.getStringExtra("PatientPhrase");
            patientText.setText(patientTranslation);
            audioFiles = new audioFiles(currentLanguage);
            String providerTranslation = receivingIntent.getStringExtra("ProviderPhrase");
            providerText.setText(providerTranslation);
        }
        catch (Exception e){
            //Set audioFiles to default if no intent information was passed, used in the case of going from welcome screen to main screen
            audioFiles = new audioFiles("English");
        }

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

        //Instantiate the switch at the bottom of the UI that converts the phrases from patient phrases to provider phrases
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup)findViewById(R.id.toggleGroup);
        int checkedId = materialButtonToggleGroup.getCheckedButtonId();
        MaterialButton patientBtn = materialButtonToggleGroup.findViewById(R.id.patientBtn);
        MaterialButton providerBtn = materialButtonToggleGroup.findViewById(R.id.providerBtn);


        //Add the onclick listener to the switch
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                //Checks which button is checked and populates the button phrases based on the switch position
                //Default position is the patient
                if (group.getCheckedButtonId() == R.id.patientBtn) {
                    //toasty.showToast(group.getContext(), "Debug message, patient is checked");
                    user = "Patient";
                    //Checks the current language then populates the buttons with the appropriate language phrases
                    switch (currentLanguage) {
                        case "English":
                            phrases = engPhrase.getPatientPhrases();
                            translatedPhrase = engPhrase.getPatientPhrases();
                            audioMap = audioFiles.getEngPatientAudio();
                            setRecyclerViewPhrases();
                            break;
                        case "French":
                            phrases = frenchPhrases.getPatientPhrases();
                            translatedPhrase = engPhrase.getPatientPhrases();
                            audioMap = audioFiles.getFrenchPatientAudio();
                            setRecyclerViewPhrases();
                            break;
                        case "Spanish":
                            phrases = spanishPhrases.getPatientPhrases();
                            translatedPhrase = engPhrase.getPatientPhrases();
                            audioMap = audioFiles.getSpanPatientAudio();
                            setRecyclerViewPhrases();
                            break;
                        default:
                            phrases = engPhrase.getPatientPhrases();
                            translatedPhrase= engPhrase.getPatientPhrases();
                            audioMap = audioFiles.getEngPatientAudio();
                            setRecyclerViewPhrases();
                    };
                }
                else if (group.getCheckedButtonId() == R.id.providerBtn){
                   // toasty.showToast(group.getContext(), "Debug message, provider is checked");
                    user = "Provider";
                        switch(currentLanguage){
                            case "English":
                                phrases = engPhrase.getProviderPhrases();
                                translatedPhrase = engPhrase.getProviderPhrases();
                                audioMap = audioFiles.getEngProviderAudio();
                                setRecyclerViewPhrases();
                                break;
                            case "French":
                                phrases = engPhrase.getProviderPhrases();
                                translatedPhrase = frenchPhrases.getProviderPhrases();
                                audioMap = audioFiles.getEngProviderAudio();
                                setRecyclerViewPhrases();
                                break;
                            case "Spanish":
                                phrases = engPhrase.getProviderPhrases();
                                translatedPhrase = spanishPhrases.getProviderPhrases();
                                audioMap = audioFiles.getEngProviderAudio();
                                setRecyclerViewPhrases();
                                break;
                            default:
                                phrases = engPhrase.getProviderPhrases();
                                translatedPhrase = engPhrase.getProviderPhrases();
                                audioMap = audioFiles.getEngProviderAudio();
                                setRecyclerViewPhrases();
                        };
                    };
                };
            });





    }

    //Function that instantiates our recyclerview and sets a layout manager on it, which is then used to actually display it onto the left side of layout
    public void setRecyclerViewPhrases(){
        //Set a layout manager for the recycler view and populate the view with the phrases
        recyclerViewPhrases = findViewById(R.id.phraseRecycler);
        recyclerViewPhrases.setHasFixedSize(true);
        recyclerViewPhrases.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewPhrases.setLayoutManager(linearLayoutManager);
        scrollingAdapter = new ScrollingAdapter(this, phrases, currentLanguage, user, engPhrase.getProviderPhrases(), audioMap, translatedPhrase);
        recyclerViewPhrases.setAdapter(scrollingAdapter);
    }

    @Override //Function to get the language from the intent (May be redundant but could be useful for clarity)
    public String getLanguage(String language) {
        //Intent information can be retrieved here if we call getLanguage from the onCreate method, helpful for clarity of program
        String currLang = language;
        return currLang;
    }

    @Override //Function that sets the language in the app to the selected language (May be redundant, will circle back to this and getLanguage)
    public void setLanguage(String language) {
        switch (language) {
            case "English":
                phrases = engPhrase.getPatientPhrases();
                audioMap = audioFiles.getEngPatientAudio();
                setRecyclerViewPhrases();
                break;
            case "French":
                phrases = frenchPhrases.getPatientPhrases();
                audioMap = audioFiles.getFrenchPatientAudio();
                setRecyclerViewPhrases();
                break;
            case "Spanish":
                phrases = spanishPhrases.getPatientPhrases();
                audioMap = audioFiles.getSpanPatientAudio();
                setRecyclerViewPhrases();
                break;
            default:
                phrases = engPhrase.getPatientPhrases();
                audioMap = audioFiles.getEngPatientAudio();
                setRecyclerViewPhrases();
        }
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

    //Function to get the context of the class (I.E. the activity that is currently running in the app)
    public Context getContext(){
        return this.getApplicationContext();
    }

}