package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class frenchPhrases {
    private List<String> frenchPhrases;
    private List<String> providerPhrases;


    public frenchPhrases(List<String> phrases){
        this.frenchPhrases = phrases;
    }


    public frenchPhrases(){
        frenchPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();

    }


    public void addProviderPhrase(String phrase){
        providerPhrases.add(phrase);
    }

    public List<String> getProviderPhrases() {
        return providerPhrases;
    }

    public void addPhrases(String phrase){
        frenchPhrases.add(phrase);
    }


    public List<String> getFrenchPhrases(){
        return frenchPhrases;
    }



}
