package com.example.languagelifeline;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import static android.content.Context.*;
import static android.os.Environment.DIRECTORY_DOCUMENTS;
import static android.os.Environment.DIRECTORY_MUSIC;

public class ReadFiles implements Serializable {

    //Create our local list variables
    public ArrayList<String> languages;
    public ArrayList<ArrayList<String>> allPhrases;
    public ArrayList<String> allLanguages;
    Context localContext;
    String message;

    public ReadFiles(){
        languages = new ArrayList<String>();
        allPhrases = new ArrayList<ArrayList<String>>();
        allLanguages = new ArrayList<String>();
        startRead();
    }

    //Constructor that accepts the context of the previous activity (Allows us to access some things we couldnt before such as local assets)
    public ReadFiles(Context context){
       localContext = context;
        //Instantiate our local variables and set our context equal to argument
        languages = new ArrayList<String>();
        allPhrases = new ArrayList<ArrayList<String>>();
        allLanguages = new ArrayList<String>();
        startRead();
    }

    public void startRead(){

        //Call our function to read assets "Languages.txt" into our local lists
        readLanguages();
        writeLanguages(); //Writes the languages to the devices local storage

        //Loop through our languages and populate our patient and provider phrase lists for each language (Might want to throw in a separate function eventually)
        for(int i =0; i <languages.size(); i++){
            allPhrases.add(readPhrase(languages.get(i), "Patient")); //AllPhrases is list of list, thus it is a list where each element contains 2 separate lists
            //I.e. [English[PatientPhrases, ProviderPhrases], Spanish[PatientPhrases, ProviderPhrases], ... ]
            for(int y = 0; y < readPhrase(languages.get(i), "Patient").size(); y++){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    String filename =  "/" + languages.get(i) + "PatientPhrases.txt";
                    if(isInFile(readPhrase(languages.get(i), "Patient").get(y).toString(), filename)){
                        //Check if our phrase is already added to the list, if so then we can ignore it
                    }
                    else{
                        //Phrase was not in our list, thus we add it
                        writePhrase(languages.get(i), "Patient", readPhrase(languages.get(i), "Patient").get(y).toString());
                    }
                }
            }
            allPhrases.add(readPhrase(languages.get(i), "Provider"));
            for(int y = 0; y < readPhrase(languages.get(i), "Provider").size(); y++){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    String filename = "/" + languages.get(i) + "ProviderPhrases.txt";
                    if(isInFile(readPhrase(languages.get(i), "Provider").get(y).toString(), filename)){
                        //Check if our phrase was already added to the list, if so then we can ignore it
                    }
                    else{
                        //Phrase was not in our list, thus we add it
                        writePhrase(languages.get(i), "Provider", readPhrase(languages.get(i), "Provider").get(y).toString());
                    }
                }
            }
        }
        readLocalLanguages();

    }

    //Function that takes languages list from local assets and writes to the device storage
    public boolean writeLanguages(){
        String basedirectory = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) { //Eventually this needs to be reworked, current build is only for older OS
            basedirectory = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOCUMENTS)); //Get the path for the music directory
        }
        basedirectory += "/LanguageLifeline/Languages.txt"; //Need to create separate folder for LL music assets
        File file = new File(basedirectory);
        file.getParentFile().mkdir();
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for(int i =0; i <languages.size(); i++){
                if(!isInFile(languages.get(i), "/LanguageLifeline/Languages.txt")){
                    pw.write(languages.get(i)+ "\r\n");
                }
            }
            pw.close();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }




    }



    //Helper function to ensure that device has storage (More for debugging purposes than functionality)
    public static boolean isSDCARDAvailable(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    //Function that checks if the passed in phrase is already present in the local file
    public boolean isInFile(String phrase, String filename) {
        String path = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            String filepath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)); //Get file directory
            path = filepath + filename;
        }
        try (FileReader fileInvc = new FileReader(path);
             BufferedReader readervc = new BufferedReader(fileInvc)) {
            String readvc = readervc.readLine();
            while (readvc != null) { //Loop through the entire file
                if (readvc.contains(phrase)) { //Check each line against our phrase
                    return true;
                }
                readvc = readervc.readLine();
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Function to write our phrase to the appropriate file based on arguments
    public void writePhrase(String language, String userType, String phrase){
        String filename = "/" + language + userType + "Phrases.txt";
        File path = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS); //Get our path
        }
        File file = new File(path, filename); //Create new file, if it doesnt already exist
        try{
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);
            pr.write(phrase + "\r\n");
            //Flush all our streams to ensure text is written
            fw.flush();
            bw.flush();
            pr.flush();
            //Close our streams
            fw.close();
            bw.close();
            pr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //Need to add 2 methods in, one that reads the languages and places them into a new file. And another function to then check if argument is in file, if not then adds it
    public boolean addLanguage(String language){
            languages.add(language);
           if(writeLanguages()){
               return true;
           }
           else{
               return false;
           }

    }


    //Method to read the languages.txt file from assets folder and parse into our arraylist
    public boolean readLanguages(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(localContext.getAssets().open("Languages.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                boolean listContains = false; //Flag variable to tell us if the list already contains the language
                for (int i =0; i < languages.size(); i++){ //Loop through and check each value of the list
                    if (languages.get(i).equals(mLine)){ //Conditional to check each value
                        listContains = true; //If the list contains the language then our flag is set to true
                    }
                }
                if (listContains == false){ //If our flag is still false, meaning the language was not found already then it is added to the arraylist
                    languages.add(mLine);
                    //To ensure that we handle any new languages we will want to add these into a list that can be parsed through for the appropriate language
                    String newPatientFile = mLine + "PatientPhrases.txt";
                    String newProviderFile = mLine + "ProviderPhrases.txt";
                    allLanguages.add(newPatientFile);
                    allLanguages.add(newProviderFile);
                }
                System.out.println("We are adding " + mLine + " to our languages arraylist"); //Debug print message
            }

        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
            return false;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return true;
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    public void readLocalLanguages(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            String filepath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
            String filename = filepath + "/LanguageLifeline/Languages.txt";
            FileReader fileInvc;
            try {
                fileInvc = new FileReader(filename);
                BufferedReader readervc = new BufferedReader(fileInvc);
                String line;
                while ((line = readervc.readLine()) != null){
                    if (!languages.contains(line)){
                        languages.add(line);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    //Function to parse the different phrase txt files and pass them into an arraylist
    public ArrayList readPhrase(String language, String userType){
        BufferedReader reader = null;
        ArrayList phraseList = new ArrayList<String>();
        String filename = language + userType + "Phrases.txt"; //Variable we build out to hold the filename we are looking for
        try {
            reader = new BufferedReader(
                    new InputStreamReader(localContext.getAssets().open(filename)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
            //    System.out.println("Adding " + mLine + " to our phraseList");
                phraseList.add(mLine);
            }

        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
            return phraseList;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    return phraseList;
                } catch (IOException e) {
                    //log the exception
                    e.printStackTrace();
                    return phraseList;
                }
            }
        }
        return phraseList;
    }



    public ArrayList getLanguages(){
        return languages;
    }

    public ArrayList<ArrayList<String>> getPhrases(){
        return allPhrases;
    }



}
