package com.example.languagelifeline;

public interface PhraseUI {
    //If you arent familiar with interfaces they are basically high level abstraction classes that can be implemented across multiple classes
    //My thinking here is having 1 interface that is then reimplemented multiple times, once for each language.





    //Getter and Setter for the language used, may not need the getter depending on how intents are used but leaving here for now
    String getLanguage(String language);
    void setLanguage(String language); //Function to set the languages across the UI to whatever language was selected


    void getPhrasePictures(String url); //Function to access the pictures we use for the phrases, arguments may change depending on how we store the pictures
    void setPhrasePictures();
    void getAudioFiles(String url);//Function to access the audio files, again may change depending on how we store files
    void setAudioFiles();





}
