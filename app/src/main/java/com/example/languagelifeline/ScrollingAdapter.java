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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {
    private Context context;
    private List<String> phrases;
    private List<String> providerPhrases;
    private OnNoteListener mOnNoteListener;
    private String language;
    private String user;
    String newPhraseglobal = "";
    private Map<String, Integer> audioFiles;


    //Constructor that takes the current context and the list of phrases
    public ScrollingAdapter(Context context, List<String> phrases, String language, String user, List<String> providerPhrases, Map<String, Integer> audioFiles){
        this.phrases= phrases;
        this.context=context;
        this.language = language;
        this.user = user;
        this.providerPhrases = providerPhrases;
        this.audioFiles = audioFiles;
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
       // toasty.showToast(context, "Our position value is " + position);
        holder.btn1.setText(phrases.get(position));
        int finalPosition = position;
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String holderPhrase = phrases.get(finalPosition);
                toasty.showToast(context, holderPhrase);
                MediaPlayer newMedia = MediaPlayer.create(view.getContext(), audioFiles.get(holderPhrase));
                newMedia.start();
                Intent intent = new Intent(context, DisplayPhrases.class);
                intent.putExtra("PatientPhrase", phrases.get(finalPosition));
                intent.putExtra("ProviderPhrase", providerPhrases.get(finalPosition));
                intent.putExtra("Language", language);
                context.startActivity(intent);
            }
        });

    }

    @Override //returns a count of the number of positions in onbindview
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




        //Constructor that is called when class is created, sets the listener and the elements in the view
        public ViewHolder(@NonNull View itemView, OnNoteListener listener) {
            super(itemView);
            this.onNoteListener = listener;
            itemView.setOnClickListener(this);
            btn1 =itemView.findViewById(R.id.btn1);



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
