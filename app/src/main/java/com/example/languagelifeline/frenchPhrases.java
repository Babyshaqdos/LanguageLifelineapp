package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class frenchPhrases {
    private List<String> frenchPhrases;


    public frenchPhrases(List<String> phrases){
        this.frenchPhrases = phrases;
    }


    public frenchPhrases(){
        frenchPhrases = new ArrayList<>();

    }


    public void addPhrases(String phrase){
        frenchPhrases.add(phrase);
    }


    public List<String> getFrenchPhrases(){
        return frenchPhrases;
    }



}
