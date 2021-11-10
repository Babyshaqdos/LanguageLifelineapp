package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class spanishPhrases {

    private List<String> patientPhrases;
    private List<String> providerPhrases;

    public spanishPhrases(List<String> phrases){
        this.patientPhrases = phrases;
    }

    public spanishPhrases(){
        patientPhrases = new ArrayList<>();
        providerPhrases = new ArrayList<>();
        providerPhrases.add("Necesita usar el baño?");
        providerPhrases.add("Tiene Hambre?");
        providerPhrases.add("Tiene sed?");
        providerPhrases.add("Quiere que yo cierre la puerta?");
        providerPhrases.add("¿Entiende?");
        providerPhrases.add("Regreso en un momento");
        providerPhrases.add("¿Está preparado para caminar?");
        providerPhrases.add("¿Quiere una bata hospitalaria nueva?");
        providerPhrases.add("¿Puede señalar dónde le duele?");
        providerPhrases.add("¿Tiene dolor?");
        providerPhrases.add("¿Cuál es su nivel de dolor?");
        providerPhrases.add("¿Quieres hielo?");
        providerPhrases.add("¿Cómo puedo ayudarle?");
        providerPhrases.add("¿Esta comoda?");
        providerPhrases.add("Tengo su comida aquí");
        providerPhrases.add("Estoy aquí para extraer sangre");
        patientPhrases.add("Voy a medir su presión arterial");
        patientPhrases.add("El doctor estará consigo muy pronto");
        patientPhrases.add("Enviare la enfermera para ayudarle");
        patientPhrases.add("Greso en un momento para ayudarle");
        patientPhrases.add("¿Tiene dificultad para respirar?");
        patientPhrases.add("Voy a verificar su temperatura");
        patientPhrases.add("Voy a verificar los signos vitales ahora");
        patientPhrases.add("¿Como se llama?");
        patientPhrases.add("¿Hay alguien consigo hoy que habla ingles?");
        patientPhrases.add("Soy su enfermera hoy");
        patientPhrases.add("Soy su enfermera esta noche");
        patientPhrases.add("Soy su doctor");
        patientPhrases.add("Soy su asistente de enfermería");

    }

    public void addProviderPhrase(String phrase){
        providerPhrases.add(phrase);
    }

    public List<String> getProviderPhrases() {
        return providerPhrases;
    }

    public void addPhrase(String phrase){
        patientPhrases.add(phrase);
    }

    public List<String> getPatientPhrases(){
        return patientPhrases;
    }


}
