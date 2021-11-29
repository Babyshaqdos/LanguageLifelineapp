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
        englishPhrases.add("I think I have a fever, could you take my temperature?");
        englishPhrases.add("Can you check my vitals?");
        englishPhrases.add("Can you charge my phone");
        englishPhrases.add("I need to make a phone call");
        englishPhrases.add("Can you close my blinds?");
        englishPhrases.add("Can you open my blinds?");
        englishPhrases.add("I cannot sleep");
        englishPhrases.add("I would like some medication to help me sleep");
        englishPhrases.add("Can I have a pillow?");
        englishPhrases.add("Can I have a blanket?");
        englishPhrases.add("Can I move to the chair?");
        englishPhrases.add("Can I raise my head?");
        englishPhrases.add("Can I lower my head?");
        englishPhrases.add("Can I change my position?");
        englishPhrases.add("I feel uncomfortable");
        englishPhrases.add("I would like to do that myself");
        englishPhrases.add("I would like that later");
        englishPhrases.add("May I see the nurse?");






        providerPhrases.add("What is your name?");
        providerPhrases.add("Does someone with you today speak English?");
        providerPhrases.add("My name is…");
        providerPhrases.add("I am your day-shift nurse");
        providerPhrases.add("I am your night-shift nurse");
        providerPhrases.add("I am your doctor");
        providerPhrases.add("I am your nursing assistant");
        providerPhrases.add("Would you like me to call a chaplain?");
        providerPhrases.add("Do you need to use the toilet?");
        providerPhrases.add("Would you like me to wipe you?");
        providerPhrases.add("Are you hungry?");
        providerPhrases.add("Are you thirsty?");
        providerPhrases.add("Would you like the door shut?");
        providerPhrases.add("Do you understand?");
        providerPhrases.add("I will be right back");
        providerPhrases.add("Can I give you your sponge bath now?");
        providerPhrases.add("Are you ready to sit up in the chair?");
        providerPhrases.add("Are you ready to take a walk?");
        providerPhrases.add("Do you want a new gown?");
        providerPhrases.add("I am going to put on your socks now");
        providerPhrases.add("Do you have pain?");
        providerPhrases.add("Can you point to where your pain is?");
        providerPhrases.add("What is your pain level?");
        providerPhrases.add("Would you like ice?");
        providerPhrases.add("Does your pain keep you from sleeping?");
        providerPhrases.add("Can I call someone for you?");
        providerPhrases.add("How can I help you?");
        providerPhrases.add("Are you comfortable?");
        providerPhrases.add("Would you like me to move you in bed?");
        providerPhrases.add("It is time to turn you in bed");
        providerPhrases.add("I am here with your meal");
        providerPhrases.add("Would you like me to open anything for you?");
        providerPhrases.add("Is the room too warm?");
        providerPhrases.add("Is the room too cold?");
        providerPhrases.add("I will be right back to assist you");
        providerPhrases.add("I am here with your medications");
        providerPhrases.add("I am sorry, I was delayed");
        providerPhrases.add("I will send the nurse in to assist you");
        providerPhrases.add("The doctor will be right with you");
        providerPhrases.add("I will check your vitals now");
        providerPhrases.add("I’m going to take your blood pressure now.");
        providerPhrases.add("I will check your temperature now");
        providerPhrases.add("I am here to draw your blood");
        providerPhrases.add("I am here for respiratory therapy");
        providerPhrases.add("I am here to give you a breathing treatment");
        providerPhrases.add("I am here to take you for an X-Ray");
        providerPhrases.add("I am here to take you for an MRI.");
        providerPhrases.add("Are you breathing okay?");
        providerPhrases.add("Are you having trouble breathing?");





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
