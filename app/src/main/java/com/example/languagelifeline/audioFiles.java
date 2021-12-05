package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//This class will contain the hash map that pairs each String representing a phrase with the appropriate audio file
public class audioFiles {
    //Declare and instantiate our hash maps, will need to find a way to generate these with code for 2nd half of the project
    static Map<String, Integer> engPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> engProviderAudio = new HashMap<String, Integer>();
    static Map<String, Integer> spanPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> spanProviderAudio = new HashMap<String, Integer>();
    static Map<String, Integer> frenchPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> frenchProviderAudio = new HashMap<String, Integer>();

    //Constructor that takes the language the provider needs translated as input
    public audioFiles(String translateToLanguage){
        //Add english patient audio files to hash map, will want to rework this over break/next semester to allow for addition of new phrases and audio files for 2nd half requirements
       engPatientAudio.put("I need to use the toilet", R.raw.i_need_to_use_the_toilet);
       engPatientAudio.put("I would like some food", R.raw.i_would_like_some_food);
       engPatientAudio.put("I would like some water", R.raw.i_would_like_some_water);
       engPatientAudio.put("What is this?", R.raw.what_is_this);
       engPatientAudio.put("My pain is better", R.raw.my_pain_is_better);
       engPatientAudio.put("My pain is worse", R.raw.my_pain_is_worse);
       engPatientAudio.put("My pain is the same", R.raw.my_pain_is_the_same);
       engPatientAudio.put("My stomach hurts", R.raw.my_stomach_hurts);
       engPatientAudio.put("I am dizzy", R.raw.i_am_dizzy);
       engPatientAudio.put("I do not feel good", R.raw.i_do_not_feel_good);
       engPatientAudio.put("I feel weak", R.raw.i_feel_weak);
       engPatientAudio.put("I am having trouble breathing", R.raw.i_am_having_trouble_breathing);
       engPatientAudio.put("I feel nauseous", R.raw.i_feel_nauseous);
       engPatientAudio.put("I think I have a fever, could you take my temperature?", R.raw.i_think_i_have_a_fever_can_you_check_my_temperature);
       engPatientAudio.put("Can you check my vitals?", R.raw.can_you_check_my_vitals);
       engPatientAudio.put("Can you charge my phone", R.raw.can_you_charge_my_phone);
       engPatientAudio.put("I need to make a phone call", R.raw.i_need_to_make_a_phone_call);
       engPatientAudio.put("Can you close my blinds?", R.raw.can_you_close_my_blinds);
       engPatientAudio.put("Can you open my blinds?", R.raw.can_you_open_my_blinds);
       engPatientAudio.put("I cannot sleep", R.raw.i_cannot_sleep);
       engPatientAudio.put("I would like some medication to help me sleep", R.raw.i_would_like_some_medication_to_help_me_sleep);
       engPatientAudio.put("Can I have a pillow?", R.raw.can_i_have_a_pillow);
       engPatientAudio.put("Can I have a blanket?", R.raw.can_i_have_a_blanket);
       engPatientAudio.put("Can I move to the chair?", R.raw.can_i_move_to_the_chair);
       engPatientAudio.put("Can I raise my head?", R.raw.can_i_raise_my_head);
       engPatientAudio.put("Can I lower my head?", R.raw.can_i_lower_my_head);
       engPatientAudio.put("Can I change my position?", R.raw.can_i_change_my_position);
       engPatientAudio.put("I feel uncomfortable", R.raw.i_feel_uncomfortable);
       engPatientAudio.put("I would like to do that myself", R.raw.i_would_like_to_do_that_myself);
       engPatientAudio.put("I would like that later", R.raw.i_would_like_that_later);
       engPatientAudio.put("May I see the nurse?", R.raw.may_i_see_the_nurse);

       //Add the spanish patient audio files to hash map
        spanPatientAudio.put("Necesito usar el baño.", R.raw.i_need_to_use_the_toilet);
        spanPatientAudio.put("Me gustaría comida.", R.raw.i_would_like_some_food);
        spanPatientAudio.put("Me gustaría agua.", R.raw.i_would_like_some_water);
        spanPatientAudio.put("¿Qué es eso?", R.raw.what_is_this);
        spanPatientAudio.put("El dolor es mejor.", R.raw.my_pain_is_better);
        spanPatientAudio.put("El dolor es peor.", R.raw.my_pain_is_worse);
        spanPatientAudio.put("El dolor es el mismo.", R.raw.my_pain_is_the_same);
        spanPatientAudio.put("Me duele el estómago.", R.raw.my_stomach_hurts);
        spanPatientAudio.put("Me siento mareado/a.", R.raw.i_am_dizzy);
        spanPatientAudio.put("No me siento bien.", R.raw.i_do_not_feel_good);
        spanPatientAudio.put("Me siento débil", R.raw.i_feel_weak);
        spanPatientAudio.put("Tengo dificultad para respirar.", R.raw.i_am_having_trouble_breathing);
        spanPatientAudio.put("Tengo náusea.", R.raw.i_feel_nauseous);
        spanPatientAudio.put("Creo que tengo fiebre. ¿Puede verificar mi temperatura?", R.raw.i_think_i_have_a_fever_can_you_check_my_temperature);
        spanPatientAudio.put("¿Puede verificar mis signos vitales?", R.raw.can_you_check_my_vitals);
        spanPatientAudio.put("¿Puede cargar el teléfono?", R.raw.can_you_charge_my_phone);
        spanPatientAudio.put("Necesito llamar a alguien por teléfono.", R.raw.i_need_to_make_a_phone_call);
        spanPatientAudio.put("¿Puede cerrar las persianas?", R.raw.can_you_close_my_blinds);
        spanPatientAudio.put("¿Puede abrir las persianas?", R.raw.can_you_open_my_blinds);
        spanPatientAudio.put("No puedo dormir.", R.raw.i_cannot_sleep);
        spanPatientAudio.put("Quiero medicina para ayudarme a dormir.", R.raw.i_would_like_some_medication_to_help_me_sleep);
        spanPatientAudio.put("¿Puedo tener una manta?", R.raw.can_i_have_a_pillow);
        spanPatientAudio.put("¿Puedo tener una almohada?", R.raw.can_i_have_a_blanket);
        spanPatientAudio.put("¿Puedo mudarme a la silla?", R.raw.can_i_move_to_the_chair);
        spanPatientAudio.put("¿Puede bajar la cabecera de la cama?", R.raw.can_i_raise_my_head);
        spanPatientAudio.put("¿Puede levantar la cabecera de la cama?", R.raw.can_i_lower_my_head);
        spanPatientAudio.put("¿Puedo cambiarme de posición?", R.raw.can_i_change_my_position);
        spanPatientAudio.put("Me siento incómodo.", R.raw.i_feel_uncomfortable);
        spanPatientAudio.put("Quiero hacer eso yo mismo.", R.raw.i_would_like_to_do_that_myself);
        spanPatientAudio.put("Quiero eso más tarde.", R.raw.i_would_like_that_later);
        spanPatientAudio.put("Necesito la enfermera.", R.raw.may_i_see_the_nurse);

        //Add the french patient audio files to hash map
        frenchPatientAudio.put("J’ai besoin d’utiliser la toilette.", R.raw.i_need_to_use_the_toilet);
        frenchPatientAudio.put("Je voudrais de la nourriture.", R.raw.i_would_like_some_food);
        frenchPatientAudio.put("Je voudrais de la boisson.", R.raw.i_would_like_some_water);
        frenchPatientAudio.put("Qu'est-ce que c'est?", R.raw.what_is_this);
        frenchPatientAudio.put("Je me sens moins de douleur.", R.raw.my_pain_is_better);
        frenchPatientAudio.put("Je me sens plus de douleur.", R.raw.my_pain_is_worse);
        frenchPatientAudio.put("Ma douleur ne change pas.", R.raw.my_pain_is_the_same);
        frenchPatientAudio.put("J’ai mal à l’estomac.", R.raw.my_stomach_hurts);
        frenchPatientAudio.put("J’ai la tête qui tourne.", R.raw.i_am_dizzy);
        frenchPatientAudio.put("Je ne me sens pas bien.", R.raw.i_do_not_feel_good);
        frenchPatientAudio.put("Je me sens faible.", R.raw.i_feel_weak);
        frenchPatientAudio.put("J’ai la difficulté avec la respiration.", R.raw.i_am_having_trouble_breathing);
        frenchPatientAudio.put("J’ai la nausée.", R.raw.i_feel_nauseous);
        frenchPatientAudio.put("Je pense que j'ai de la fièvre. Pouvez-vous prendre ma température?", R.raw.i_think_i_have_a_fever_can_you_check_my_temperature);
        frenchPatientAudio.put("Pouvez-vous prendre mes signes vitaux?", R.raw.can_you_check_my_vitals);
        frenchPatientAudio.put("Pouvez-vous recharger mon téléphone?", R.raw.can_you_charge_my_phone);
        frenchPatientAudio.put("J’ai besoin de passer un coup de téléphone.", R.raw.i_need_to_make_a_phone_call);
        frenchPatientAudio.put("Pouvez-vous fermer les stores?", R.raw.can_you_close_my_blinds);
        frenchPatientAudio.put("Pouvez-vous ouvrir les stores?", R.raw.can_you_open_my_blinds);
        frenchPatientAudio.put("Je ne peux pas dormir.", R.raw.i_cannot_sleep);
        frenchPatientAudio.put("Je voudrais un médicament pour dormir.", R.raw.i_would_like_some_medication_to_help_me_sleep);
        frenchPatientAudio.put("Puis-je avoir un oreiller?", R.raw.can_i_have_a_pillow);
        frenchPatientAudio.put("Puis-je avoir une couverture?", R.raw.can_i_have_a_blanket);
        frenchPatientAudio.put("Puis-je aller à la chaise?", R.raw.can_i_move_to_the_chair);
        frenchPatientAudio.put("Puis-je lever la tête?", R.raw.can_i_raise_my_head);
        frenchPatientAudio.put("Puis-je baisser la tête?", R.raw.can_i_lower_my_head);
        frenchPatientAudio.put("Puis-je changer ma position?", R.raw.can_i_change_my_position);
        frenchPatientAudio.put("Je me sens mal à l’aise.", R.raw.i_feel_uncomfortable);
        frenchPatientAudio.put("Je voudrais faire ça moi-même.", R.raw.i_would_like_to_do_that_myself);
        frenchPatientAudio.put("Je voudrais ça plus tard.", R.raw.i_would_like_that_later);
        frenchPatientAudio.put("J’ai besoin de infirmier?", R.raw.may_i_see_the_nurse);



        //Takes the passed in string value and calls the appropriate method to translate provider audio
        switch(translateToLanguage){
            case "Spanish":
                translateSpanish();
                break;
            case "French":
                translateFrench();
                break;
            case "English":
                translateEnglish();
                break;
            default: //Will want to find a better way of handling default languages in the future
                translateEnglish();
                break;
        }

    }

    //Function to take the provider phrases and translate it from default (english- for now) to spanish
    //As before will want to find better way to do this using a more iterative approach
    public void translateSpanish(){
        engProviderAudio.put("What is your name?", R.raw.como_se_llama);
        engProviderAudio.put("Does someone with you today speak English?", R.raw.hay_alguien_consigo_hoy_que_habla_ingles);
        engProviderAudio.put("My name is ", R.raw.me_llamo);
        engProviderAudio.put("I am your day shift nurse", R.raw.soy_su_enfermera_hoy);
        engProviderAudio.put("I am your night shift nurse", R.raw.soy_su_enfermera_esta_noche);
        engProviderAudio.put("I am your doctor", R.raw.soy_su_doctor);
        engProviderAudio.put("I am your nursing assistant", R.raw.soy_su_asistente_de_enfermeria);
        engProviderAudio.put("Would you like me to call a chaplain?", R.raw.quiere_que_llame_a_un_capellan);
        engProviderAudio.put("Do you need to use the toilet?", R.raw.necesita_usar_el_bano);
        engProviderAudio.put("Would you like me to wipe you?", R.raw.puedo_ayudarse_a_limpiar);
        engProviderAudio.put("Are you hungry?", R.raw.tiene_hambre);
        engProviderAudio.put("Are you thirsty?", R.raw.tiene_sed);
        engProviderAudio.put("Would you like the door shut?", R.raw.quiere_que_yo_cierre_la_puerta);
        engProviderAudio.put("Do you understand?", R.raw.entiende);
        engProviderAudio.put("I will be right back", R.raw.regreso_en_un_momento);
        engProviderAudio.put("Can I give you your sponge bath now?", R.raw.puedo_darte_un_bano_de_esponja_ahora);
        engProviderAudio.put("Are you ready to sit up in the chair?", R.raw.esta_preparado_para_sentirse_en_la_silla);
        engProviderAudio.put("Are you ready to take a walk?", R.raw.esta_preparado_para_caminar);
        engProviderAudio.put("Do you want a new gown?", R.raw.quiere_una_bata_hospitalaria_nueva);
        engProviderAudio.put("I am going to put on your socks now", R.raw.voy_a_ponerse_los_calcetines_ahora);
        engProviderAudio.put("Do you have pain?", R.raw.puede_senalar_donde_le_duele);
        engProviderAudio.put("Can you point to where your pain is?", R.raw.tiene_dolor);
        engProviderAudio.put("What is your pain level?", R.raw.cual_es_su_nivel_de_dolor);
        engProviderAudio.put("Would you like ice?", R.raw.quiere_hielo);
        engProviderAudio.put("Does your pain keep you from sleeping?", R.raw.es_su_dolor_tan_grave_que_no_puede_dormir);
        engProviderAudio.put("Can I call someone for you?", R.raw.puedo_ayudarle_a_llamar_a_alguien_por_telefono);
        engProviderAudio.put("How can I help you?",  R.raw.como_puedo_ayudarle);
        engProviderAudio.put("Are you comfortable?", R.raw.esta_comoda);
        engProviderAudio.put("Would you like me to move you in bed?", R.raw.quiere_que_le_coloque_en_otra_posicion);
        engProviderAudio.put("It is time to turn you in bed", R.raw.es_hora_de_darle_vuelta);
        engProviderAudio.put("I am here with your meal", R.raw.tengo_su_comida_aqui);
        engProviderAudio.put("Would you like me to open anything for you?", R.raw.quiere_que_abra_alguna_cosa_para_usted);
        engProviderAudio.put("Is the room too warm?", R.raw.es_demasiado_calido_el_cuarto);
        engProviderAudio.put("Is the room too cold?", R.raw.es_demasiado_frio_el_cuarto);
        engProviderAudio.put("I will be right back to assist you", R.raw.regreso_en_un_momento_para_ayudarle);
        engProviderAudio.put("I am here with your medications", R.raw.estoy_aqui_con_sus_medicinas);
        engProviderAudio.put("I am  sorry, I was delayed", R.raw.lo_siento_fui_retrasado);
        engProviderAudio.put("I will send the nurse in to assist you", R.raw.enviare_la_enfermera_para_ayudarle);
        engProviderAudio.put("The doctor will be right with you", R.raw.el_doctor_estara_consigo_muy_pronto);
        engProviderAudio.put("I will check your vitals now", R.raw.voy_a_verificar_los_signos_vitales_ahora);
        engProviderAudio.put("I'm going to check your blood pressure now", R.raw.voy_a_medir_su_presion_arterial);
        engProviderAudio.put("I will check your temperature now", R.raw.voy_a_verificar_su_temperatura);
        engProviderAudio.put("I am here to draw your blood", R.raw.estoy_aqui_para_extraer_sangre);
        engProviderAudio.put("I am here for respiratory therapy", R.raw.estoy_aqui_para_darle_terapia_respiratoria);
        engProviderAudio.put("I am here to give you a breathing treatment", R.raw.estoy_aqui_para_darle_un_tratamiento_respiratorio);
        engProviderAudio.put("I am here to take you for an X-Ray", R.raw.estoy_aqui_para_llevarle_a_un_examen_de_rayos_x);
        engProviderAudio.put("I am here to take you for an MRI", R.raw.estoy_aqui_para_llevarle_a_un_examen_de_rmn);
        engProviderAudio.put("Are you breathing okay?", R.raw.respiras_bien);
        engProviderAudio.put("Are you having troubles breathing?", R.raw.tiene_dificultad_para_respirar);

    }

    //Function to translate the provider phrases into french
    public void translateFrench(){
        engProviderAudio.put("What is your name?", R.raw.comment_vous_appelez_vous);
        engProviderAudio.put("Does someone with you today speak English?", R.raw.il_y_a_quelqu_un_ici_qui_parle_l_anglais);
        engProviderAudio.put("My name is ", R.raw.je_m_appelle);
        engProviderAudio.put("I am your day shift nurse", R.raw.je_suis_votre_infirmiere_pendant_la_journee);
        engProviderAudio.put("I am your night shift nurse", R.raw.je_suis_votre_infirmiere_pendant_la_nuit);
        engProviderAudio.put("I am your doctor", R.raw.je_suis_votre_medecin);
        engProviderAudio.put("I am your nursing assistant", R.raw.je_suis_votre_infirmiere_auxiliaire);
        engProviderAudio.put("Would you like me to call a chaplain?", R.raw.est_ce_que_vous_voulez_j_appelle_un_chapelain);
        engProviderAudio.put("Do you need to use the toilet?", R.raw.vous_avez_besoin_d_utiliser_la_toilette);
        engProviderAudio.put("Would you like me to wipe you?", R.raw.devrais_je_vous_essuyer);
        engProviderAudio.put("Are you hungry?", R.raw.vous_avez_faim);
        engProviderAudio.put("Are you thirsty?", R.raw.vous_avez_soif);
        engProviderAudio.put("Would you like the door shut?", R.raw.devrais_je_fermer_la_porte);
        engProviderAudio.put("Do you understand?", R.raw.vous_comprenez);
        engProviderAudio.put("I will be right back", R.raw.je_reviens_tout_de_suite);
        engProviderAudio.put("Can I give you your sponge bath now?", R.raw.puis_je_donner_ton_lavage_a_l_eponge);
        engProviderAudio.put("Are you ready to sit up in the chair?", R.raw.etes_vous_pret_pour_se_redresser_dans_la_chaise);
        engProviderAudio.put("Are you ready to take a walk?", R.raw.etes_vous_pret_pour_une_promenade);
        engProviderAudio.put("Do you want a new gown?", R.raw.voulez_vous_une_nouvelle_blouse_d_hopital);
        engProviderAudio.put("I am going to put on your socks now", R.raw.je_mets_vos_chaussettes_maintenant);
        engProviderAudio.put("Do you have pain?", R.raw.vous_avez_de_la_douleur);
        engProviderAudio.put("Can you point to where your pain is?", R.raw.pouvez_vous_montrer_du_doigt_votre_douleur);
        engProviderAudio.put("What is your pain level?", R.raw.quel_est_votre_niveau_de_douleur);
        engProviderAudio.put("Would you like ice?", R.raw.vous_voudrais_des_glacons);
        engProviderAudio.put("Does your pain keep you from sleeping?", R.raw.vous_ne_pouvez_pas_dormir_parce_que_votre_douleur);
        engProviderAudio.put("Can I call someone for you?", R.raw.puis_je_appeler_quelqu_un_pour_vous);
        engProviderAudio.put("How can I help you?",  R.raw.comment_puis_je_vous_aider);
        engProviderAudio.put("Are you comfortable?", R.raw.etes_vous_confortable);
        engProviderAudio.put("Would you like me to move you in bed?", R.raw.voudriez_vous_bouger_en_lit);
        engProviderAudio.put("It is time to turn you in bed", R.raw.c_est_le_temps_pour_vous_tourner_en_lit);
        engProviderAudio.put("I am here with your meal", R.raw.je_suis_ici_avec_votre_repas);
        engProviderAudio.put("Would you like me to open anything for you?", R.raw.voudriez_vous_ouvrir_quelque_chose);
        engProviderAudio.put("Is the room too warm?", R.raw.est_ce_que_la_temperature_est_trop_chaude_pour_vous);
        engProviderAudio.put("Is the room too cold?", R.raw.est_ce_que_la_temperature_est_trop_froide_pour_vous);
        engProviderAudio.put("I will be right back to assist you", R.raw.je_rentrai_pour_vous_assister);
        engProviderAudio.put("I am here with your medications", R.raw.je_suis_ici_avec_vos_medicaments);
        engProviderAudio.put("I am  sorry, I was delayed", R.raw.je_suis_desolee_je_suis_en_retard);
        engProviderAudio.put("I will send the nurse in to assist you", R.raw.je_dirai_l_infirmier_de_vous_assister);
        engProviderAudio.put("The doctor will be right with you", R.raw.le_medecin_viendrai_tres_vite);
        engProviderAudio.put("I will check your vitals now", R.raw.je_verifierai_vos_signes_vitaux_maintenant);
        engProviderAudio.put("I'm going to check your blood pressure now", R.raw.je_prends_votre_tension_arterielle_maintenant);
        engProviderAudio.put("I will check your temperature now", R.raw.je_verifierai_votre_temperature_maintenant);
        engProviderAudio.put("I am here to draw your blood", R.raw.je_suis_ici_pour_faire_couler_le_sang_pour_vous);
        engProviderAudio.put("I am here for respiratory therapy", R.raw.je_suis_ici_pour_la_therapie_respiratoire);
        engProviderAudio.put("I am here to give you a breathing treatment", R.raw.je_suis_ici_pour_vous_donner_un_traitement_pour_respiration);
        engProviderAudio.put("I am here to take you for an X-Ray", R.raw.je_suis_ici_pour_un_radiographie);
        engProviderAudio.put("I am here to take you for an MRI", R.raw.je_suis_ici_pour_un_irm);
        engProviderAudio.put("Are you breathing okay?", R.raw.etes_vous_respirer_bien);
        engProviderAudio.put("Are you having troubles breathing?", R.raw.avez_vous_un_probleme_respiratoire);

    }

    //Function to translate provider phrases into english (not used for 1st half of project, will revisit when option to change default language is implemented)
    public void translateEnglish(){

    }


    //Getter functions to return the hash maps
    public static Map<String, Integer> getEngProviderAudio(){
        return engProviderAudio;
    }
    public static Map<String, Integer> getSpanProviderAudio(){
        return spanProviderAudio;
    }
    public static Map<String, Integer> getEngPatientAudio() {
        return engPatientAudio;
    }
    public static Map<String, Integer> getSpanPatientAudio(){
        return spanPatientAudio;
    }
    public static Map<String, Integer> getFrenchPatientAudio(){
        return frenchPatientAudio;
    }

}
