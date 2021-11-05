package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class spanishPhrases {

    private List<String> spanishPhrases;

    public spanishPhrases(List<String> phrases){
        this.spanishPhrases = phrases;
    }

    public spanishPhrases(){
        spanishPhrases = new ArrayList<>();

    }

    public void addPhrase(String phrase){
        spanishPhrases.add(phrase);
    }

    public List<String> getSpanishPhrases(){
        return spanishPhrases;
    }


}
