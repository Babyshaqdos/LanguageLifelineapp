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
