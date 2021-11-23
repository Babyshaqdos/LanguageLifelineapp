package com.example.languagelifeline;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {
    private Context context;
    private List<String> phrases;
    private List<String> providerPhrases;
    private OnNoteListener mOnNoteListener;
    private String language;
    private String user;
    String newPhraseglobal = "";


    //Constructor that takes the current context and the list of phrases
    public ScrollingAdapter(Context context, List<String> phrases, String language, String user, List<String> providerPhrases){
        this.phrases= phrases;
        this.context=context;
        this.language = language;
        this.user = user;
        this.providerPhrases = providerPhrases;
    }

    //Constructor that takes the current context, the list of phrases, and a listener for the buttons in the view
    public ScrollingAdapter(Context context, List<String> phrases, OnNoteListener listener){
        this.phrases = phrases;
        this.context = context;
        mOnNoteListener = listener;
    }

    @NonNull
    @Override //This method is called when the viewholder is called for the first time, inflates the phraselistUI into the parent view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phraselistui, parent,false);
        return new ScrollingAdapter.ViewHolder(view, mOnNoteListener);
    }

    //This method is called any time the viewholder is updated, aka whenever the user scrolls on the left side of the screen
    @Override //Will get the position of the scrollbar then update the buttons according (Still needs image updating adding)
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Utils toasty = new Utils();
        String newPhrase;
        //Debugging message
        toasty.showToast(context, "Our position value is " + position);
        //Probably want to change this to a switch at some point
        //Sets each button with a phrase from the phrases list
        if (position == 0 ){
            holder.btn1.setText(phrases.get(0));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(0));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(0)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(1));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(1));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(1));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(2));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(2));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(2));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(3));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(3));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(3));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(4));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(4));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(4));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(5));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(5));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(5));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(6));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(6));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(6));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(7));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(7));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(7));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(8));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(8));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(8));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(9));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(9));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(9));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }
        else if (position == 1){
            holder.btn1.setText(phrases.get(10));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(10));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(10)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(11));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(11));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(11));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(12));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(12));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(12));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(13));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(13));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(13));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(14));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(14));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(14));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(15));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(15));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(15));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(16));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(16));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(16));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(17));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(17));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(17));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(18));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(18));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(18));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(19));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(19));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(19));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }
        else if (position ==2){
            holder.btn1.setText(phrases.get(20));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(20));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(20)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(21));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(21));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(21));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(22));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(22));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(22));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(23));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(23));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(23));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(24));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(24));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(24));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(25));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(25));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(25));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(26));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(26));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(26));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(27));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(27));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(27));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(28));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(28));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(28));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(29));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(29));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(29));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }
        else if (position ==3){
            holder.btn1.setText(phrases.get(30));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(30));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(30)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(31));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(31));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(31));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(32));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(32));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(32));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(33));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(33));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(33));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(34));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(34));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(34));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(35));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(35));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(35));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(36));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(36));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(36));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(37));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(37));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(37));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(38));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(38));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(38));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(39));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(39));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(39));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }
        else if (position ==4){
            holder.btn1.setText(phrases.get(40));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(40));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(40)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(41));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(41));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(41));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(42));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(42));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(42));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(43));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(43));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(43));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(44));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(44));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(44));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(45));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(45));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(45));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(46));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(46));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(46));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(47));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(47));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(47));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(48));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(48));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(48));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(49));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(49));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(49));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }
        else{
            holder.btn1.setText(phrases.get(50));
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(50));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(50)); //Will need to devise a naming convention or order to reliably grab these string values
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn2.setText(phrases.get(51));
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(51));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(51));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn3.setText(phrases.get(52));
            holder.btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.may_i_see_the_nurse);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(52));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(52));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn4.setText(phrases.get(53));
            holder.btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_understand);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(53));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(53));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn5.setText(phrases.get(54));
            holder.btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_pain_where);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(54));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(54));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn6.setText(phrases.get(55));
            holder.btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(55));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(55));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
            holder.btn7.setText(phrases.get(56));
            holder.btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_make_a_phone_call);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(56));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(56));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn8.setText(phrases.get(57));
            holder.btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.is_there_family_i_can_call_for_you);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(57));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(57));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn9.setText(phrases.get(58));
            holder.btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.what_is_your_name);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(58));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(58));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);

                }
            });
            holder.btn10.setText(phrases.get(59));
            holder.btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                    newMedia.start();
                    Intent intent = new Intent(context, DisplayPhrases.class);
                    intent.putExtra("PatientPhrase", phrases.get(59));
                    intent.putExtra("ProviderPhrase", providerPhrases.get(59));
                    intent.putExtra("Language", language);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override //returns a count of the number of positions in onbindview
    public int getItemCount() {
        return 2;
    }


    //Viewholder class that actually extends the recyclerview and implements the listener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Instantiate all of our buttons and imageviews
        OnNoteListener onNoteListener;
        public Button btn1;
        public Button btn2;
        public Button btn3;
        public Button btn4;
        public Button btn5;
        public Button btn6;
        public Button btn7;
        public Button btn8;
        public Button btn9;
        public Button btn10;




        //Constructor that is called when class is created, sets the listener and the elements in the view
        public ViewHolder(@NonNull View itemView, OnNoteListener listener) {
            super(itemView);
            this.onNoteListener = listener;
            itemView.setOnClickListener(this);
            btn1 =itemView.findViewById(R.id.btn1);
            btn2 =itemView.findViewById(R.id.btn2);
            btn3 = itemView.findViewById(R.id.btn3);
            btn4 = itemView.findViewById(R.id.btn4);
            btn5 = itemView.findViewById(R.id.btn5);
            btn6 = itemView.findViewById(R.id.btn6);
            btn7 = itemView.findViewById(R.id.btn7);
            btn8 = itemView.findViewById(R.id.btn8);
            btn9 = itemView.findViewById(R.id.btn9);
            btn10 = itemView.findViewById(R.id.btn10);


        }
        @Override
        public void onClick(View view) {
            try{
                onNoteListener.onNoteClick(getAdapterPosition());
            }
            catch (Exception e){

            }
        }

        public Context getApplicationContext() {
            return context.getApplicationContext();
        }
    }


    public interface OnNoteListener{
        void onNoteClick(int position);
    }


}
