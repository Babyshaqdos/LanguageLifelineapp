package com.example.languagelifeline;

import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {
    private Context context;
    private List<String> phrases;
    //private List<>
    private OnNoteListener mOnNoteListener;


    //Constructor that takes the current context and the list of phrases
    public ScrollingAdapter(Context context, List<String> phrases){
        this.phrases= phrases;
        this.context=context;
    }

    //Constructor that takes the current context, the list of phrases, and a listener for the buttons in the view
    public ScrollingAdapter(Context context, List<String> phrases, OnNoteListener listener){
        this.phrases = phrases;
        this.context = context;
        this.mOnNoteListener = listener;
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
        //Debugging message
        //toasty.showToast(context, "Our position value is " + position);

        //Probably want to change this to a switch at some point
        //Sets each button with a phrase from the phrases list
        if (position == 0 ){
            holder.btn1.setText(phrases.get(0));
            holder.btn2.setText(phrases.get(1));
            holder.btn3.setText(phrases.get(2));
            holder.btn4.setText(phrases.get(3));
            holder.btn5.setText(phrases.get(4));
            holder.btn6.setText(phrases.get(5));
        }
        else if (position == 1){
            holder.btn1.setText(phrases.get(5));
            holder.btn2.setText(phrases.get(4));
            holder.btn3.setText(phrases.get(3));
            holder.btn4.setText(phrases.get(2));
            holder.btn5.setText(phrases.get(1));
            holder.btn6.setText(phrases.get(0));
        }
        else if (position ==2){
            holder.btn1.setText(phrases.get(3));
            holder.btn2.setText(phrases.get(2));
            holder.btn3.setText(phrases.get(1));
            holder.btn4.setText(phrases.get(0));
            holder.btn5.setText(phrases.get(4));
            holder.btn6.setText(phrases.get(5));
        }
        else if (position ==3){
            holder.btn1.setText(phrases.get(2));
            holder.btn2.setText(phrases.get(1));
            holder.btn3.setText(phrases.get(0));
            holder.btn4.setText(phrases.get(3));
            holder.btn5.setText(phrases.get(4));
            holder.btn6.setText(phrases.get(5));
        }
        else if (position ==4){
            holder.btn1.setText(phrases.get(5));
            holder.btn2.setText(phrases.get(4));
            holder.btn3.setText(phrases.get(0));
            holder.btn4.setText(phrases.get(1));
            holder.btn5.setText(phrases.get(2));
            holder.btn6.setText(phrases.get(3));
        }
        else {
            holder.btn1.setText(phrases.get(1));
            holder.btn2.setText(phrases.get(0));
            holder.btn3.setText(phrases.get(4));
            holder.btn4.setText(phrases.get(2));
            holder.btn5.setText(phrases.get(3));
            holder.btn6.setText(phrases.get(5));
        }
        //Want to look into getting a list of the images to iterate through
        // holder.img1.setImageDrawable();


    }

    @Override //Gets a count of the number of phrases passed into viewholder, may want to change to return number of buttons instantiated but for now this will work (function may not even be used)
    public int getItemCount() {
        return phrases.size();
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
        public TextView patientTranslation;
        public TextView providerTranslation;
        public ImageButton repeatBtn;
        public Button didntMeanBtn;
        public Button yesBtn;
        public Button nobtn;
        public Button dontunderstandbtn;
        public Button needTranslatorbtn;



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
            patientTranslation = itemView.findViewById(R.id.patientBtn);
            providerTranslation = itemView.findViewById(R.id.providerBtn);
            repeatBtn = itemView.findViewById(R.id.repeatButton);
            nobtn = itemView.findViewById(R.id.answerNobtn);
            yesBtn = itemView.findViewById(R.id.answerYesbtn);
            dontunderstandbtn = itemView.findViewById(R.id.dontUnderstandBtn);
            didntMeanBtn = itemView.findViewById(R.id.didntMeanToBtn);
            needTranslatorbtn = itemView.findViewById(R.id.needInterpreter);



            //Need to find a way to check for the language selected as well as the patient or provider

            //Set the audio files into the buttons
            //Set the audio files into the buttons
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_need_to_use_the_toilet);
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_water);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_have_any_known_allergies);
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.i_would_like_some_food);
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.my_stomach_hurts);
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.my_stomach_hurts);
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.are_you_hungry);
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.are_you_hungry);
                }
            });

            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.are_you_hungry);
                }
            });

            btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.are_you_hungry);
                }
            });
            repeatBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Come back to this, need to figure out how to store the last selected phrase as a variable to pass into this method
                  //  MediaPlayer newMedia = MediaPlayer.create(view.getContext(), )
                }
            });
            yesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.yes_that_is_fine);
                }
            });
            nobtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.no_i_am_not_okay_with_that);
                }
            });
            needTranslatorbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), R.raw.do_you_need_an_interpreter);
                }
            });


           /* btn7 = itemView.findViewById(R.id.btn7);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            img3 = itemView.findViewById(R.id.img3);
            img4 = itemView.findViewById(R.id.img4);
            img5 = itemView.findViewById(R.id.img5);
            img6 = itemView.findViewById(R.id.img6);
            img7 = itemView.findViewById(R.id.img7);
*/
        }
        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }


    public interface OnNoteListener{
        void onNoteClick(int position);
    }


}
