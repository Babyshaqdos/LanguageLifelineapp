package com.example.languagelifeline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class DisplayPhrases extends AppCompatActivity implements PhraseUI {

    private RecyclerView recyclerViewPhrases;
    private ScrollingAdapter scrollingAdapter;
    private ScrollingAdapter scrollingAdapter2;
    private GridLayout gridLayoutRight;
    public List<String> phrases;
    public String currentLanguage;
    public englishPhrases engPhrase;
    private frenchPhrases frenchPhrases;
    private spanishPhrases spanishPhrases;
    public String user;
    public TextView patientText;
    public TextView providerText;
    final Utils toasty = new Utils();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        phrases = new ArrayList<>();
        user = "Patient";
        patientText = (TextView)findViewById(R.id.patientPhrase);
        providerText = (TextView)findViewById(R.id.providerLangPhrase);

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
        setLanguage(currentLanguage);
        try{
            String patientTranslation = receivingIntent.getStringExtra("PatientPhrase");
            patientText.setText(patientTranslation);
            String providerTranslation = receivingIntent.getStringExtra("ProviderPhrase");
            providerText.setText(providerTranslation);
        }
        catch (Exception e){
            //Do nothing
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
                    toasty.showToast(group.getContext(), "Debug message, patient is checked");
                    user = "Patient";
                    //Checks the current language then populates the buttons with the appropriate language phrases
                    switch (currentLanguage) {
                        case "English":
                            phrases = engPhrase.getEnglishPhrases();
                            setRecyclerViewPhrases();
                            break;
                        case "French":
                            phrases = frenchPhrases.getFrenchPhrases();
                            setRecyclerViewPhrases();
                            break;
                        case "Spanish":
                            phrases = spanishPhrases.getSpanishPhrases();
                            setRecyclerViewPhrases();
                            break;
                        default:
                            phrases = engPhrase.getEnglishPhrases();
                            setRecyclerViewPhrases();
                    };
                }
                else if (group.getCheckedButtonId() == R.id.providerBtn){
                    toasty.showToast(group.getContext(), "Debug message, provider is checked");
                    user = "Provider";
                        switch(currentLanguage){
                            case "English":
                                phrases = engPhrase.getProviderPhrases();
                                setRecyclerViewPhrases();
                                break;
                            case "French":
                                phrases = frenchPhrases.getProviderPhrases();
                                setRecyclerViewPhrases();
                                break;
                            case "Spanish":
                                phrases = spanishPhrases.getProviderPhrases();
                                setRecyclerViewPhrases();
                                break;
                            default:
                                phrases = engPhrase.getProviderPhrases();
                                setRecyclerViewPhrases();
                        };
                    };
                };
            });





    }

    public void setRecyclerViewPhrases(){
        //Set a layout manager for the recycler view and populate the view with the phrases
        recyclerViewPhrases = findViewById(R.id.phraseRecycler);
        recyclerViewPhrases.setHasFixedSize(true);
        recyclerViewPhrases.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewPhrases.setLayoutManager(linearLayoutManager);
        scrollingAdapter = new ScrollingAdapter(this, phrases, currentLanguage, user, engPhrase.getProviderPhrases());
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
        switch (language) {
            case "English":
                phrases = engPhrase.getEnglishPhrases();
                setRecyclerViewPhrases();
                break;
            case "French":
                phrases = frenchPhrases.getFrenchPhrases();
                setRecyclerViewPhrases();
                break;
            case "Spanish":
                phrases = spanishPhrases.getSpanishPhrases();
                setRecyclerViewPhrases();
                break;
            default:
                phrases = engPhrase.getEnglishPhrases();
                setRecyclerViewPhrases();
        }
    }


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String phrase = intent.getStringExtra("patientLang");
            patientText.setText(phrase);
        }
    };

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

    public Context getContext(){
        return this.getApplicationContext();
    }

    public void setPhrase(String phrase){
        setContentView(R.layout.ui_main);
        patientText.setText(phrase);
    }
}