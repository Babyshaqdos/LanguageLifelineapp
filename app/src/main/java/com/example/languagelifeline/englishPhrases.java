package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

//Class to hold our english phrases for both patient and provider
public class englishPhrases {
    //Declare our list of phrases for both patients and providers
    private List<String> patientPhrases;
    private List<String> providerPhrases;


    //Constructor to set the local phrases as the passed in engPhrases (may not be useful for now but may come in handy for the addition of phrases later)
    public englishPhrases(List<String> engPhrases){

    }

    //Constructor that intializes the englishPhrases arraylist
    public englishPhrases(){
        //Initalize our lists
        patientPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();
        //Add the phrases into the patient list, will want to want better way of doing this similar to the audio files class
        //Potential solutions: Place phrases into text file and parse text file into the list
        patientPhrases.add("I need to use the toilet");
        patientPhrases.add("I would like some food");
        patientPhrases.add("I would like some water");
        patientPhrases.add("What is this?");
        patientPhrases.add("My pain is better");
        patientPhrases.add("My pain is worse");
        patientPhrases.add("My pain is the same");
        patientPhrases.add("My stomach hurts");
        patientPhrases.add("I am dizzy");
        patientPhrases.add("I do not feel good");
        patientPhrases.add("I feel weak");
        patientPhrases.add("I am having trouble breathing");
        patientPhrases.add("I feel nauseous");
        patientPhrases.add("I think I have a fever, could you take my temperature?");
        patientPhrases.add("Can you check my vitals?");
        patientPhrases.add("Can you charge my phone");
        patientPhrases.add("I need to make a phone call");
        patientPhrases.add("Can you close my blinds?");
        patientPhrases.add("Can you open my blinds?");
        patientPhrases.add("I cannot sleep");
        patientPhrases.add("I would like some medication to help me sleep");
        patientPhrases.add("Can I have a pillow?");
        patientPhrases.add("Can I have a blanket?");
        patientPhrases.add("Can I move to the chair?");
        patientPhrases.add("Can I raise my head?");
        patientPhrases.add("Can I lower my head?");
        patientPhrases.add("Can I change my position?");
        patientPhrases.add("I feel uncomfortable");
        patientPhrases.add("I would like to do that myself");
        patientPhrases.add("I would like that later");
        patientPhrases.add("May I see the nurse?");





        //Add the provider phrases into the list
        providerPhrases.add("What is your name?");
        providerPhrases.add("Does someone with you today speak English?");
        providerPhrases.add("My name is");
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
        providerPhrases.add("I am here to take you for an MRI");
        providerPhrases.add("Are you breathing okay?");
        providerPhrases.add("Are you having trouble breathing?");





    }

    //Function to add phrase from another class
    public void addPhrasePatient(String newPhrase){
        patientPhrases.add((newPhrase));
    }

    //Getter to return the patient phrases
    public List<String> getPatientPhrases(){
        return patientPhrases;
    }

    //Function to add phrase to provider list from another class
    public void addPhraseProvider(String newPhrase){
        providerPhrases.add(newPhrase);
    }

    //Getter to return the provider phrases
    public List<String> getProviderPhrases(){
        return providerPhrases;
    }

}
