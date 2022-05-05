package com.example.languagelifeline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


//This is your main class that is called when the application is started
public class Welcome extends AppCompatActivity {
    final Utils toasty = new Utils(); //Contains debugging message
    private RecyclerView recyclerViewLanguages;
    private Button connectClientBtn;
    private LanguageAdapter languageAdapter;
    List<String> languages;
    Context context;
    ReadFiles readFiles;
    String myJson;

    //All classes that contain the code to display the UI will need to have an onCreate method, it is the first method called by the application when it switches to this class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome); //This line will change the displayed UI to whichever layout file you specify
        connectClientBtn = (Button)findViewById(R.id.connectBtn); //ConnectClient button for now, want to add to menu at top right if time allows

        checkPermissions();
        Utils.onActivityCreateSetTheme(this);




        //Call our ReadFiles class in order to read our built in phrases and languages into the application
        readFiles = new ReadFiles(this);



        languages = readFiles.getLanguages(); //Set our local languages list equal to our read in list of languages
        setRecyclerViewPhrases(); //Instantiates, populates, and displays our languages in a scrollable adapter

        //Set an on click listener to the connect client button to navigate to the UI screen that handles client-server connection
        connectClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayClient.class);
                startActivity(intent);
            }
        });

        //Creates the spinner for the top right that allows for changing of font size (Will want to revisit later)
     /*   Spinner textSizeDropdown = (Spinner) findViewById(R.id.textSizeDropdown);
        textSizeDropdown.setSelection(Utils.getCurrentIndex(), false);
        textSizeDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                if (Utils.getCurrentIndex() == i) return;
                System.out.println("Option:" + i + " selected!");
                switch (i) {
                    case 0:
                        Utils.changeToTheme(Welcome.this, FontTheme.SMALL);
                        break;
                    case 1:
                        Utils.changeToTheme(Welcome.this, FontTheme.MEDIUM);
                        break;
                    case 2:
                        Utils.changeToTheme(Welcome.this, FontTheme.LARGE);;
                        break;
                    default:
                        Utils.changeToTheme(Welcome.this, FontTheme.MEDIUM);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }); */
    }

    //Debugging function to check that the user has allowed permissions on the application
    private boolean checkPermissions(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
         //   toasty.showToast(this, "Permission granted");
            return true;
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            toasty.showToast(this, "Storage Permission Denied, please go to app setting and allow access to storage");
            return false;
        }
    }


    //Function that instantiates our recyclerview and sets a layout manager on it, which is then used to actually display it onto the left side of layout
    public void setRecyclerViewPhrases(){
        //Set a layout manager for the recycler view and populate the view with the phrases
        recyclerViewLanguages = findViewById(R.id.languagerecycler);
        recyclerViewLanguages.setHasFixedSize(true);
        recyclerViewLanguages.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerViewLanguages.setLayoutManager(linearLayoutManager);
        languageAdapter = new LanguageAdapter(this, languages, readFiles);
        recyclerViewLanguages.setAdapter(languageAdapter);
    }


}