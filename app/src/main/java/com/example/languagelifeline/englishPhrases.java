package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class englishPhrases {
    private List<String> englishPhrases;
    private List<String> providerPhrases;


    //Constructor to set the local phrases as the passed in engPhrases (may not be useful for now but may come in handy for the addition of phrases later)
    public englishPhrases(List<String> engPhrases){

    }

    //Constructor that intializes the englishPhrases arraylist
    public englishPhrases(){
        englishPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();
        //We need to add code here to populate the phrase list
        //Go phrase by phrase and add them like so
        englishPhrases.add("I need to use the restroom");
        englishPhrases.add("I need to use the restroom");
        englishPhrases.add("May I have an interpreter");
        englishPhrases.add("I would like some food");
        englishPhrases.add("I would like something to drink");
        englishPhrases.add("What brings you in today?");
        englishPhrases.add("Is there any family members I can call for you?");
    }

    //Function to add phrase from another class
    public void addPhrasePatient(String newPhrase){
        englishPhrases.add((newPhrase));
    }


    public List<String> getEnglishPhrases(){
        return englishPhrases;
    }


    public void addPhraseProvider(String newPhrase){
        providerPhrases.add(newPhrase);
    }

    public List<String> getProviderPhrases(){
        return providerPhrases;
    }

}
