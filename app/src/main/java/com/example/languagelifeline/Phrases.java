package com.example.languagelifeline;

import android.icu.text.StringSearch;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Phrases {

    //Declare our list of phrases for both patients and providers
    private List<String> patientPhrases;
    private List<String> providerPhrases;


    Phrases(){
        patientPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();
    }


    //I need a function that checks if the previous patient phrases list is already populated or not (alternatively, maybe I can just re instantiate the lists each call?)
    public List<String> readPatientPhrases(String language){
        patientPhrases = new ArrayList<>();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            String filepath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
            String filename = filepath + "/" + language + "PatientPhrases.txt";
            FileReader fileInvc;
            try {
                fileInvc = new FileReader(filename);
                BufferedReader readervc = new BufferedReader(fileInvc);
                String line;
                while ((line = readervc.readLine()) != null){
                    patientPhrases.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return patientPhrases;
    }


    public List<String> readProviderPhrases(String language){
        File path = null;
        providerPhrases = new ArrayList<>();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        }

        String filename = language + "ProviderPhrases.txt";
        File file = new File(path, filename);

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                providerPhrases.add(line);
            }
        } catch (Exception e){
            System.out.println("Shits fucked in phrases.java, readProviderPhrases try catch");
        }
        return providerPhrases;
    }






}
