package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class frenchPhrases {
    private List<String> patientPhrases;
    private List<String> providerPhrases;


    public frenchPhrases(List<String> phrases){
        this.patientPhrases = phrases;
    }


    public frenchPhrases(){
        patientPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();

        patientPhrases.add("Comment vous-appelez vous?");
        patientPhrases.add("Il y a quelqu'un ici qui parle l’anglais?");
        patientPhrases.add("Je m’appelle…");
        patientPhrases.add("Je suis votre infirmière pendant la journée");
        patientPhrases.add("Je suis votre infirmière pendant la nuit");
        patientPhrases.add("Je suis votre médecin");
        patientPhrases.add("Je suis votre infirmière auxiliaire");
        patientPhrases.add("Est-ce que vous voulez  j'appelle un chapelain?");
        patientPhrases.add("Vous avez besoin d’utiliser la toilette?");
        patientPhrases.add("Devrais-je vous essuyer?");
        patientPhrases.add("Vous avez faim?");
        patientPhrases.add("Vous avez soif?");
        patientPhrases.add("Devrais-je fermer la porte?");
        patientPhrases.add("Vous comprenez?");
        patientPhrases.add("Je reviens tout de suite");
        patientPhrases.add("Puis-je donner ton lavage à l'éponge?");
        patientPhrases.add("Etes-vous prêt pour se redresser dans la chaise?");
        patientPhrases.add("Etes-vous prêt pour une promenade?");
        patientPhrases.add("Voulez-vous une nouvelle blouse d'hôpital?");
        patientPhrases.add("Je mets vos chaussettes maintenant");
        patientPhrases.add("Vous avez de la douleur?");
        patientPhrases.add("Pouvez vous montrer du doigt votre douleur?");
        patientPhrases.add("Quel est votre niveau de douleur?");
        patientPhrases.add("Vous voudrais des glaçons?");
        patientPhrases.add("Vous ne pouvez pas dormir parce que votre douleur?");
        patientPhrases.add("Can I call someone for you?");
        patientPhrases.add("How can I help you?");
        patientPhrases.add("Are you comfortable?");
        patientPhrases.add("Would you like me to move you in bed?");
        patientPhrases.add("It is time to turn you in bed");
        patientPhrases.add("I am here with your meal");
        patientPhrases.add("Would you like me to open anything for you?");
        patientPhrases.add("Is the room too warm?");
        patientPhrases.add("Is the room too cold?");
        patientPhrases.add("I will be right back to assist you");
        patientPhrases.add("I am here with your medications");
        patientPhrases.add("I am sorry, I was delayed");
        patientPhrases.add("I will send the nurse in to assist you");
        patientPhrases.add("The doctor will be right with you");
        patientPhrases.add("I will check your vitals now");
        patientPhrases.add("I’m going to take your blood pressure now.");
        patientPhrases.add("I will check your temperature now");
        patientPhrases.add("I am here to draw your blood");
        patientPhrases.add("I am here for respiratory therapy");
        patientPhrases.add("I am here to give you a breathing treatment");
        patientPhrases.add("I am here to take you for an X-Ray");
        patientPhrases.add("I am here to take you for an MRI.");
        patientPhrases.add("Are you breathing okay?");
        patientPhrases.add("Are you having trouble breathing?");

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


    public void addProviderPhrase(String phrase){
        providerPhrases.add(phrase);
    }

    public List<String> getProviderPhrases() {
        return providerPhrases;
    }

    public void addPhrases(String phrase){
        patientPhrases.add(phrase);
    }


    public List<String> getFrenchPhrases(){
        return patientPhrases;
    }



}
