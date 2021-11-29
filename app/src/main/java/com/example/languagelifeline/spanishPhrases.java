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
        patientPhrases.add("Necesito usar el baño.");
        patientPhrases.add("Me gustaría comida.");
        patientPhrases.add("Me gustaría agua.");
        patientPhrases.add("¿Qué es eso?");
        patientPhrases.add("El dolor es mejor.");
        patientPhrases.add("El dolor es peor.");
        patientPhrases.add("El dolor es el mismo.");
        patientPhrases.add("Me duele el estómago.");
        patientPhrases.add("Me siento mareado/a.");
        patientPhrases.add("No me siento bien.");
        patientPhrases.add("Me siento débil");
        patientPhrases.add("Tengo dificultad para respirar.");
        patientPhrases.add("Tengo náusea.");
        patientPhrases.add("Creo que tengo fiebre. ¿Puede verificar mi temperatura?");
        patientPhrases.add("¿Puede verificar mis signos vitales?");
        patientPhrases.add("¿Puede cargar el teléfono?");
        patientPhrases.add("Necesito llamar a alguien por teléfono.");
        patientPhrases.add("¿Puede cerrar las persianas?");
        patientPhrases.add("¿Puede abrir las persianas?");
        patientPhrases.add("No puedo dormir.");
        patientPhrases.add("Quiero medicina para ayudarme a dormir.");
        patientPhrases.add("¿Puedo tener una manta?");
        patientPhrases.add("¿Puedo tener una almohada?");
        patientPhrases.add("¿Puedo mudarme a la silla?");
        patientPhrases.add("¿Puede bajar la cabecera de la cama?");
        patientPhrases.add("¿Puede levantar la cabecera de la cama?");
        patientPhrases.add("¿Puedo cambiarme de posición?");
        patientPhrases.add("Me siento incómodo.");
        patientPhrases.add("Quiero hacer eso yo mismo.");
        patientPhrases.add("Quiero eso más tarde.");
        patientPhrases.add("Necesito la enfermera.");






        providerPhrases.add("¿Como se llama?");
        providerPhrases.add("¿Hay alguien consigo hoy que habla inglés?");
        providerPhrases.add("Me llamo...");
        providerPhrases.add("Soy su enfermera hoy.");
        providerPhrases.add("Soy su enfermera esta noche.");
        providerPhrases.add("Soy su doctor.");
        providerPhrases.add("Soy su asistente de enfermería.");
        providerPhrases.add("¿Quiere que llame a un capellán?");
        providerPhrases.add("Necesita usar el baño?");
        providerPhrases.add("¿Puedo ayudarse a limpiar?");
        providerPhrases.add("Tiene hambre?");
        providerPhrases.add("Tiene sed?");
        providerPhrases.add("Quiere que yo cierre la puerta?");
        providerPhrases.add("¿Entiende?");
        providerPhrases.add("Regreso en un momento");
        providerPhrases.add("¿Puedo darte un baño de esponja ahora?");
        providerPhrases.add("¿Está preparado para sentirse en la silla?");
        providerPhrases.add("¿Está preparado para caminar?");
        providerPhrases.add("¿Quiere una bata hospitalaria nueva?");
        providerPhrases.add("Voy a ponerse los calcetines ahora. ");
        providerPhrases.add("¿Puede señalar dónde le duele?");
        providerPhrases.add("¿Tiene dolor?");
        providerPhrases.add("¿Cuál es su nivel de dolor?");
        providerPhrases.add("¿Quieres hielo?");
        providerPhrases.add("¿Es su dolor tan grave que no puede dormir?");
        providerPhrases.add("¿Puedo ayudarle a llamar a alguien por teléfono?");
        providerPhrases.add("¿Cómo puedo ayudarle?");
        providerPhrases.add("¿Está cómoda?");
        providerPhrases.add("¿Quiere que le coloque en otra posición?");
        providerPhrases.add("Es hora de darle vuelta.");
        providerPhrases.add("Tengo su comida aquí");
        providerPhrases.add("¿Quiere que abra alguna cosa para usted?");
        providerPhrases.add("¿Es demasiado cálido el cuarto? ");
        providerPhrases.add("¿Es demasiado frío el cuarto?");
        providerPhrases.add("Regreso en un momento para ayudarle.");
        providerPhrases.add("Estoy aquí con sus medicinas. ");
        providerPhrases.add("Lo siento, fui retrasado.");
        providerPhrases.add("Enviaré la enfermera para ayudarle.");
        providerPhrases.add("El doctor estará consigo muy pronto.");
        providerPhrases.add("Voy a verificar los signos vitales ahora.");
        providerPhrases.add("Voy a medir su presión arterial.");
        providerPhrases.add("Voy a verificar su temperatura.");
        providerPhrases.add("Estoy aquí para extraer sangre");
        providerPhrases.add("Estoy aquí para darle terapia respiratoria.");
        providerPhrases.add("Estoy aquí para darle un tratamiento respiratorio. ");
        providerPhrases.add("Estoy aquí para llevarle a un examen de rayos x. ");
        providerPhrases.add("Estoy aquí para llevarle a un examen de RMN. ");
        providerPhrases.add("¿Respiras bien?");
        providerPhrases.add("¿Tiene dificultad para respirar?");


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
