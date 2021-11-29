package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class audioFiles {
    static Map<String, Integer> engPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> engProviderAudio = new HashMap<String, Integer>();
    static Map<String, Integer> spanPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> spanProviderAudio = new HashMap<String, Integer>();
    static Map<String, Integer> frenchPatientAudio = new HashMap<String, Integer>();
    static Map<String, Integer> frenchProviderAudio = new HashMap<String, Integer>();


    public audioFiles(){
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

    }


    public static Map<String, Integer> getEngPatientAudio() {
        return engPatientAudio;
    }

    public static Map<String, Integer> getSpanPatientAudio(){
        return spanPatientAudio;
    }
}
