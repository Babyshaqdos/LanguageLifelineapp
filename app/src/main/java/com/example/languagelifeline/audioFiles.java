package com.example.languagelifeline;

import java.util.ArrayList;
import java.util.List;

public class audioFiles {
    private List<String> engAudioFiles;
    private List<String> spanishAudioFiles;
    private List<String> frenchAudioFiles;


    public audioFiles(){
        engAudioFiles = new ArrayList<>();
       // englishFiles = {R.raw.i_need_to_use_the_toilet, R.raw.i_would_like_some_food, R.raw.i_would_like_some_water, R.raw.what_is_this, R.raw.my_pain_is_better, R.raw.my_pain_is_worse, R.raw.my_pain_is_the_same, R.raw.my_stomach_hurts, R.raw.i_am_dizzy, R.raw.i_do_not_feel_good, R.raw.i_feel_weak, R.raw.i_am_having_trouble_breathing, R.raw.i_feel_nauseous, R.raw.can_you_check_my_vitals, R.raw.can_you_charge_my_phone, R.raw.i_need_to_make_a_phone_call, R.raw.can_you_close_my_blinds, R.raw.can_you_open_my_blinds, R.raw.i_cannot_sleep, R.raw.can_i_have_a_pillow, R.raw.can_i_have_a_blanket, R.raw.can_i_change_my_position, R.raw.i_feel_uncomfortable, R.raw.i_would_like_that_later}
        engAudioFiles.add("R.raw.i_need_to_use_the_toilet");

    }


    public List<String> getEngAudioFiles(){
      return engAudioFiles;
    };

    public List<String> getSpanishAudioFiles(){
        return spanishAudioFiles;
    }
    public List<String> getFrenchAudioFiles(){
        return frenchAudioFiles;
    }


}
