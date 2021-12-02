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

        patientPhrases.add("J’ai besoin d’utiliser la toilette.");
        patientPhrases.add("Je voudrais de la nourriture.");
        patientPhrases.add("Je voudrais de la boisson.");
        patientPhrases.add("Qu'est-ce que c'est?");
        patientPhrases.add("Je me sens moins de douleur.");
        patientPhrases.add("Je me sens plus de douleur.");
        patientPhrases.add("Ma douleur ne change pas.");
        patientPhrases.add("J’ai mal à l’estomac.");
        patientPhrases.add("J’ai la tête qui tourne.");
        patientPhrases.add("Je ne me sens pas bien.");
        patientPhrases.add("Je me sens faible.");
        patientPhrases.add("J’ai la difficulté avec la respiration.");
        patientPhrases.add("J’ai la nausée.");
        patientPhrases.add("Je pense que j'ai de la fièvre. Pouvez-vous prendre ma température?");
        patientPhrases.add("Pouvez-vous prendre mes signes vitaux?");
        patientPhrases.add("Pouvez-vous recharger mon téléphone?");
        patientPhrases.add("J’ai besoin de passer un coup de téléphone.");
        patientPhrases.add("Pouvez-vous fermer les stores?");
        patientPhrases.add("Pouvez-vous ouvrir les stores?");
        patientPhrases.add("Je ne peux pas dormir.");
        patientPhrases.add("Je voudrais un médicament pour dormir.");
        patientPhrases.add("Puis-je avoir un oreiller?");
        patientPhrases.add("Puis-je avoir une couverture?");
        patientPhrases.add("Puis-je aller à la chaise?");
        patientPhrases.add("Puis-je lever la tête?");
        patientPhrases.add("Puis-je baisser la tête?");
        patientPhrases.add("Puis-je changer ma position?");
        patientPhrases.add("Je me sens mal à l’aise.");
        patientPhrases.add("Je voudrais faire ça moi-même.");
        patientPhrases.add("Je voudrais ça plus tard.");
        patientPhrases.add("J’ai besoin de infirmier?");

        providerPhrases.add("Comment vous-appelez vous?");
        providerPhrases.add("Il y a quelqu'un ici qui parle l’anglais?");
        providerPhrases.add("Je m’appelle...");
        providerPhrases.add("Je suis votre infirmière pendant la journée.");
        providerPhrases.add("Je suis votre infirmière pendant la nuit.");
        providerPhrases.add("Je suis votre médecin.");
        providerPhrases.add("Je suis votre infirmière auxiliaire.");
        providerPhrases.add("Est-ce que vous voulez j'appelle un chapelain?");
        providerPhrases.add("Vous avez besoin d’utiliser la toilette?");
        providerPhrases.add("Devrais-je vous essuyer?");
        providerPhrases.add("Vous avez faim?");
        providerPhrases.add("Vous avez soif?");
        providerPhrases.add("Devrais-je fermer la porte?");
        providerPhrases.add("Vous comprenez?");
        providerPhrases.add("Je reviens tout de suite.");
        providerPhrases.add("Puis-je donner ton lavage à l'éponge?");
        providerPhrases.add("Etes-vous prêt pour se redresser dans la chaise?");
        providerPhrases.add("Etes-vous prêt pour une promenade?");
        providerPhrases.add("Voulez-vous une nouvelle blouse d'hôpital?");
        providerPhrases.add("Je mets vos chaussettes maintenant.");
        providerPhrases.add("Vous avez de la douleur?");
        providerPhrases.add("Pouvez vous montrer du doigt votre douleur?");
        providerPhrases.add("Quel est votre niveau de douleur?");
        providerPhrases.add("Vous voudrais des glaçons?");
        providerPhrases.add("Vous ne pouvez pas dormir parce que votre douleur?");
        providerPhrases.add("Puis-je appeler quelqu'un pour vous?");
        providerPhrases.add("Comment puis-je vous aider?");
        providerPhrases.add("Êtes-vous confortable?");
        providerPhrases.add("Voudriez-vous bouger en lit?");
        providerPhrases.add("C’est le temps pour vous tourner en lit.");
        providerPhrases.add("Je suis ici avec votre repas.");
        providerPhrases.add("Voudriez-vous ouvrir quelque chose?");
        providerPhrases.add("Est-ce que la température est trop chaude pour vous?");
        providerPhrases.add("Est-ce que la température est trop froide pour vous?");
        providerPhrases.add("Je rentrai pour vous assister.");
        providerPhrases.add("Je suis ici avec vos médicaments.");
        providerPhrases.add("Je suis désolée, je suis en retard.");
        providerPhrases.add("Je dirai l’infirmier de vous assister.");
        providerPhrases.add("Le médecin viendrai très vite.");
        providerPhrases.add("Je vérifierai vos signes vitaux maintenant.");
        providerPhrases.add("Je prends votre tension artérielle maintenant.");
        providerPhrases.add("Je vérifierai votre température maintenant.");
        providerPhrases.add("Je suis ici pour faire couler le sang pour vous.");
        providerPhrases.add("Je suis ici pour la thérapie respiratoire.");
        providerPhrases.add("Je suis ici pour vous donner un traitement pour respiration.");
        providerPhrases.add("Je suis ici pour un radiographie.");
        providerPhrases.add("Je suis ici pour un IRM.");
        providerPhrases.add("Êtes vous respirer bien?");
        providerPhrases.add("Avez-vous un problème respiratoire?");

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
