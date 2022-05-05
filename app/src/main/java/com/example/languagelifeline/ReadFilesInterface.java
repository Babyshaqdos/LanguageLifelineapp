package com.example.languagelifeline;

import java.util.ArrayList;

public interface ReadFilesInterface {
    //If you arent familiar with interfaces they are basically high level abstraction classes that can be implemented across multiple classes
    //My thinking here is having 1 interface that is then reimplemented multiple times, once for each language.

    public void startRead();
    public boolean writeLanguages();
    public boolean isInFile(String phrase, String filename);
    public void writePhrase(String language, String userType, String phrase);
    public boolean addLanguage(String language);
    public boolean readLanguages();
    public void readLocalLanguages();
    public ArrayList readPhrase(String language, String userType);
    public ArrayList getLanguages();
    public ArrayList<ArrayList<String>> getPhrases();






}
