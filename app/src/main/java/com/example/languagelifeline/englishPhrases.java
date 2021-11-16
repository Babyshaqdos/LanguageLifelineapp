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
        //Might be able to make this better by placing all of the phrases inside of a text file then reading the text file and parsing it into the arraylist
        englishPhrases.add("I need to use the toilet");
        englishPhrases.add("I would like some food");
        englishPhrases.add("I would like some water");
        englishPhrases.add("What is this?");
        englishPhrases.add("My pain is better");
        englishPhrases.add("My pain is worse");
        englishPhrases.add("My pain is the same");
        englishPhrases.add("My stomach hurts");
        englishPhrases.add("I am dizzy");
        englishPhrases.add("I do not feel good");
        englishPhrases.add("I feel weak");
        englishPhrases.add("I am having trouble breathing");
        englishPhrases.add("I feel nauseous");
        englishPhrases.add("Can you check my vitals?");
        englishPhrases.add("Can you charge my phone");
        englishPhrases.add("I need to make a phone call");
        englishPhrases.add("Can you close my blinds?");
        englishPhrases.add("Can you open my blinds?");
        englishPhrases.add("I cannot sleep");
        englishPhrases.add("Can I have a pillow?");
        englishPhrases.add("Can I have a blanket?");
        englishPhrases.add("Can I change my position?");
        englishPhrases.add("I feel uncomfortable");
        englishPhrases.add("I would like that later");
        englishPhrases.add("canhaveblanket.png");






        providerPhrases.add("Do you need to use the toilet?");
        providerPhrases.add("Do you have pain?");
        providerPhrases.add("Can you point to where your pain is?");
        providerPhrases.add("What is your name?");
        providerPhrases.add("Do you have any known allergies?");
        providerPhrases.add("Are you hungry?");
        providerPhrases.add("Are you thirsty?");
        providerPhrases.add("Do you need an interpreter?");
        providerPhrases.add("The doctor will be right with you");
        providerPhrases.add("Is there family I can call for you?");
        providerPhrases.add("Do you understand?");
        providerPhrases.add("Do you take any other medications?");




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
