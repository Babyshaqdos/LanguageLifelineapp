package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class spanishPhrases {

    private List<String> spanishPhrases;
    private List<String> providerPhrases;

    public spanishPhrases(List<String> phrases){
        this.spanishPhrases = phrases;
    }

    public spanishPhrases(){
        spanishPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();
    }

    public void addProviderPhrase(String phrase){
        providerPhrases.add(phrase);
    }

    public List<String> getProviderPhrases() {
        return providerPhrases;
    }

    public void addPhrase(String phrase){
        spanishPhrases.add(phrase);
    }

    public List<String> getSpanishPhrases(){
        return spanishPhrases;
    }


}
