package com.example.languagelifeline;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

public class DisplayPhrases extends AppCompatActivity  {

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
    public Context context;
    public TextView providerText;
    final Utils toasty = new Utils();
    private audioFiles audioFiles;
    public Map<String, Integer> audioMap = new HashMap<>();
    public ImageButton repeatBtn;
    public Button yesBtn;
    public Button noBtn;
    public Button dontUnderstandBtn;
    public Button needInterpreterBtn;
    public Button didntmeantoBtn;
    public List<String> langList;
    ReadFiles read;
    Phrases phraseClass;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem colorblindOption = menu.findItem(R.id.colorblind_toggle);
        colorblindOption.setChecked(Utils.isColorblind);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.font_size_small:
                Utils.changeToTheme(DisplayPhrases.this, FontTheme.SMALL);
                return true;
            case R.id.font_size_medium:
                Utils.changeToTheme(DisplayPhrases.this, FontTheme.MEDIUM);
                return true;
            case R.id.font_size_large:
                Utils.changeToTheme(DisplayPhrases.this, FontTheme.LARGE);
                return true;
            case R.id.colorblind_toggle:
                Utils.changeToTheme(DisplayPhrases.this, !Utils.isColorblind);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override //onCreate is called as soon as this activity is started
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.ui_main); //Set the layout
        //Instantiate our variables and objects for local use
        phrases = new ArrayList<>();
        user = "Patient";
        context = this.getApplicationContext();
        patientText = (TextView)findViewById(R.id.patientPhrase);
        providerText = (TextView)findViewById(R.id.providerPhrase);
        engPhrase = new englishPhrases();
        frenchPhrases = new frenchPhrases();
        phraseClass = new Phrases();
        spanishPhrases = new spanishPhrases();
      //  translatedPhrase = engPhrase.getProviderPhrases();
        repeatBtn = (ImageButton)findViewById(R.id.repeatButton);
        yesBtn = (Button)findViewById(R.id.yesbtn);
        noBtn = (Button)findViewById(R.id.nobtn);
        audioFiles = new audioFiles("English", this);
        dontUnderstandBtn = (Button)findViewById(R.id.dontunderstandbtn);
        needInterpreterBtn = (Button)findViewById(R.id.needInterpreter);
        didntmeantoBtn = (Button)findViewById(R.id.didntMeanToBtn);
        //Get our intent, used to send variable information between activities
        Intent receivingIntent = getIntent();
        langList = receivingIntent.getStringArrayListExtra("LanguageList");

        //Get the current language to populate the phrases/buttons
        currentLanguage = receivingIntent.getStringExtra("Language");
      //  toasty.showToast(this, "LAnguage is " + currentLanguage);
        setLanguage(currentLanguage);
        try{ //Want to use a try catch here to handle any exceptions raised by receiving an empty intent, non empty intents are sent from scrolling adapter on the onclick
            String patientTranslation = receivingIntent.getStringExtra("PatientPhrase");
            patientText.setText(patientTranslation);
            audioFiles = new audioFiles(currentLanguage, this);
            String providerTranslation = receivingIntent.getStringExtra("ProviderPhrase");
            providerText.setText(providerTranslation);
            setAudioMap(currentLanguage, user);
            String repeatAudio = receivingIntent.getStringExtra("AudioFile");
           // toasty.showToast(context, repeatAudio);
            repeatBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), audioMap.get(repeatAudio));
                        mediaPlayer.start();
                    }
                    catch (Exception e){
                        //Do nothing

                    }

                }
            });
        //    toasty.showToast(this, "Debug message, we are about to call setLanguage(" + currentLanguage + ") in our try catch block");
            setLanguage(currentLanguage);
        }
        catch (Exception e){
         //   toasty.showToast(this, "Our try catch failed on language " + currentLanguage);
            //Set audioFiles to default if no intent information was passed, used in the case of going from welcome screen to main screen
            audioFiles = new audioFiles("English", this);
            setLanguage(currentLanguage);
        }
       // setRecyclerViewPhrases();
        //Instantiate the button to send the user back to the home page to select a new language
        Button homeBtn = (Button)findViewById(R.id.homeBtn);

        //Set the listener for the button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the intent and send the user back to the Welcome class (home screen)
                Intent homeIntent = new Intent(view.getContext(), Welcome.class);
                homeIntent.putExtra("FirstRun", "No");
                startActivity(homeIntent);
            }
        });

        //Instantiate the switch at the bottom of the UI that converts the phrases from patient phrases to provider phrases
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup)findViewById(R.id.toggleGroup);
        int checkedId = materialButtonToggleGroup.getCheckedButtonId();
        MaterialButton patientBtn = materialButtonToggleGroup.findViewById(R.id.patientBtn);
        MaterialButton providerBtn = materialButtonToggleGroup.findViewById(R.id.providerBtn);
        patientBtn.setBackgroundColor(getResources().getColor(R.color.Yale_Blue));
        providerBtn.setBackgroundColor(Color.DKGRAY);

        //Add the onclick listener to the switch
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                //Checks which button is checked and populates the button phrases based on the switch position
                //Default position is the patient
                if (group.getCheckedButtonId() == R.id.patientBtn) {
                    patientBtn.setBackgroundColor(getResources().getColor(R.color.Yale_Blue));
                    providerBtn.setBackgroundColor(Color.DKGRAY);
                    //toasty.showToast(group.getContext(), "Debug message, patient is checked");
                    user = "Patient";
                    //Checks the current language then populates the buttons with the appropriate language phrases
                //Above loop will be easier to read method of doing the switch case, need to find better way of handling the audio files first
                    switch (currentLanguage) { //Will need to add a list of all languages, then loop through and check each language in list against currentLanguage
                        case "English":
                            phrases = new ArrayList<>();
                            phrases = phraseClass.readPatientPhrases("English");
                            System.out.println("Our patient phrases are : " + phrases);
                            translatedPhrase = phraseClass.readPatientPhrases("English");
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
                            for(int i =0; i < langList.size(); i++){
                                //    toasty.showToast(getApplicationContext(), "We are populating " + langList.get(i));
                                if (currentLanguage.equalsIgnoreCase(langList.get(i))){
                                    phrases = new ArrayList<>();
                                    phrases = phraseClass.readPatientPhrases(currentLanguage);
                                    translatedPhrase = phraseClass.readProviderPhrases(currentLanguage);
                                    setRecyclerViewPhrases();
                                }
                            }
                    };
                }
                else if (group.getCheckedButtonId() == R.id.providerBtn){
                   // toasty.showToast(group.getContext(), "Debug message, provider is checked");
                    providerBtn.setBackgroundColor(getResources().getColor(R.color.Yale_Blue));
                    patientBtn.setBackgroundColor(Color.DKGRAY);
                    user = "Provider";
                        switch(currentLanguage){
                            case "English":
                                phrases = new ArrayList<>();
                                phrases = phraseClass.readProviderPhrases("English");
                                System.out.println("Our provider phrases are : " + phrases);
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
                                for(int i =0; i < langList.size(); i++){
                                    //    toasty.showToast(getApplicationContext(), "We are populating " + langList.get(i));
                                    if (currentLanguage.equalsIgnoreCase(langList.get(i))){
                                        phrases = new ArrayList<>();
                                        translatedPhrase = phraseClass.readPatientPhrases(currentLanguage);
                                        phrases = phraseClass.readProviderPhrases(currentLanguage);
                                        setRecyclerViewPhrases();
                                    }
                                }
                                break;
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
        scrollingAdapter = new ScrollingAdapter(this, phrases, currentLanguage, user, engPhrase.getProviderPhrases(), audioMap, translatedPhrase, read);
        phrases = new ArrayList<>();
        recyclerViewPhrases.setAdapter(scrollingAdapter);
    }

    //Function to get the language from the intent (May be redundant but could be useful for clarity)
    public String getLanguage(String language) {
        //Intent information can be retrieved here if we call getLanguage from the onCreate method, helpful for clarity of program
        String currLang = language;
        return currLang;
    }


    public void setAudioMap(String language, String user){
        switch(user){
            case "Patient":
                switch(language){
                    case "English":
                        audioMap = audioFiles.getEngPatientAudio();
                        break;
                    case "French":
                        audioMap = audioFiles.getFrenchPatientAudio();
                        break;
                    case "Spanish":
                        audioMap = audioFiles.getSpanPatientAudio();
                        break;
                }
            case "Provider":
                audioFiles = new audioFiles(language, this);
                audioMap = audioFiles.getEngProviderAudio();
                break;
        }
    }

     //Function that sets the language in the app to the selected language (May be redundant, will circle back to this and getLanguage)
    public void setLanguage(String language) {
        switch (language){
            case "English":
                phrases = phraseClass.readPatientPhrases("English");
                translatedPhrase = phraseClass.readProviderPhrases("English");
                audioMap = audioFiles.getEngPatientAudio();
                yesBtn.setText("Yes");
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.yes);
                        mediaPlayer.start();
                    }
                });
                noBtn.setText("No");
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.no_english);
                        mediaPlayer.start();
                    }
                });
                didntmeantoBtn.setText("I didn't mean to say that");
                didntmeantoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_didn_t_mean_to_say_that);
                        mediaPlayer.start();
                    }
                });
                dontUnderstandBtn.setText("I don't understand");
                dontUnderstandBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_don_t_understand);
                        mediaPlayer.start();
                    }
                });
                needInterpreterBtn.setText("I need an interpreter");
                needInterpreterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_need_an_interpreter);
                        mediaPlayer.start();
                    }
                });
         //       setRecyclerViewPhrases();
                break;
            case "French":
                phrases = frenchPhrases.getPatientPhrases();
                translatedPhrase = engPhrase.getPatientPhrases();
                audioMap = audioFiles.getFrenchPatientAudio(); //Changed from get eng provider
                yesBtn.setText("Oui");
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.oui);
                        mediaPlayer.start();
                    }
                });
                noBtn.setText("Non");
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.non);
                        mediaPlayer.start();
                    }
                });
                didntmeantoBtn.setText("Je ne voulais pas dire ça");
                didntmeantoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.je_ne_voulais_pas_dire_ca);
                        mediaPlayer.start();
                    }
                });
                dontUnderstandBtn.setText("Je ne comprends pas");
                dontUnderstandBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.je_ne_comprends_pas);
                        mediaPlayer.start();
                    }
                });
                needInterpreterBtn.setText("J'ai besoin d'un interprète");
                needInterpreterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.j_ai_besoin_d_un_interprete);
                        mediaPlayer.start();
                    }
                });
           //     setRecyclerViewPhrases();
                break;
            case "Spanish":
                phrases = spanishPhrases.getPatientPhrases();
                translatedPhrase = engPhrase.getPatientPhrases();
                audioMap = audioFiles.getSpanPatientAudio();
                yesBtn.setText("Sí");
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.si);
                        mediaPlayer.start();
                    }
                });
                noBtn.setText("No");
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.no_spanish);
                        mediaPlayer.start();
                    }
                });
                didntmeantoBtn.setText("No quise");
                didntmeantoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.no_quise_decir_eso);
                        mediaPlayer.start();
                    }
                });
                dontUnderstandBtn.setText("No entiendo");
                dontUnderstandBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.no_entiendo);
                        mediaPlayer.start();
                    }
                });
                needInterpreterBtn.setText("Necesito un intérprete");
                needInterpreterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.necesito_un_interprete);
                        mediaPlayer.start();
                    }
                });
            //    setRecyclerViewPhrases();
                break;
            default:
                for(int i =0; i < langList.size(); i++) {
                    //    toasty.showToast(getApplicationContext(), "We are populating " + langList.get(i));
                    if (currentLanguage.equalsIgnoreCase(langList.get(i))) {
                        phrases = new ArrayList<>();
                        phrases = phraseClass.readPatientPhrases(currentLanguage);
                        translatedPhrase = phraseClass.readProviderPhrases(currentLanguage);
                     //   setRecyclerViewPhrases();
                    }
                }
                yesBtn.setText("Yes");
                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.yes);
                        mediaPlayer.start();
                    }
                });
                noBtn.setText("No");
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.no_english);
                        mediaPlayer.start();
                    }
                });
                didntmeantoBtn.setText("I didn't mean to say that");
                didntmeantoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_didn_t_mean_to_say_that);
                        mediaPlayer.start();
                    }
                });
                dontUnderstandBtn.setText("I don't understand");
                dontUnderstandBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_don_t_understand);
                        mediaPlayer.start();
                    }
                });
                needInterpreterBtn.setText("I need an interpreter");
                needInterpreterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.i_need_an_interpreter);
                        mediaPlayer.start();
                    }
                });
                    break;
        }
        setRecyclerViewPhrases();
    }



    //Function to get the context of the class (I.E. the activity that is currently running in the app)
    public Context getContext(){
        return this.getApplicationContext();
    }

}