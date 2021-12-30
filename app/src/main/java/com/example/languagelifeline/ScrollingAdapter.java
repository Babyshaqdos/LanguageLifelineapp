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


//Adapter class that can handle the recycler view and repopulate it with each scroll
public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {

    //Declare our local variables and objects
    private Context context;
    private List<String> phrases;
    private List<String> providerPhrases;
    private List<String> translatedProviderPhrases;
    private OnNoteListener mOnNoteListener;
    private String language;
    private String user;
    private Map<String, Integer> audioFiles;


    //Constructor that takes the current context, list of phrases for both provider and patient, the current language, whether the user is a patient or provider, and a map of the audiofiles
    public ScrollingAdapter(Context context, List<String> phrases, String language, String user, List<String> providerPhrases, Map<String, Integer> audioFiles, List<String> translatedProviderPhrases){
        this.phrases= phrases;
        this.context=context;
        this.language = language;
        this.user = user;
        this.providerPhrases = providerPhrases;
        this.audioFiles = audioFiles;
        this.translatedProviderPhrases = translatedProviderPhrases;
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
        final Utils toasty = new Utils(); //Class that holds our toast message function (used for debugging purposes)

        holder.btn1.setText(phrases.get(position)); //Holder is the viewgroup containing the phraselistui layout, line sets the button text based on the position in the phrases
        int finalPosition = position;
        holder.btn1.setOnClickListener(new View.OnClickListener() { //Set an onclick listener to the button
            @Override
            public void onClick(View view) {
                String holderPhrase = phrases.get(finalPosition); //Get the phrase using our final int
              //  toasty.showToast(context, holderPhrase);
                //Create a media player object and pass in the correct audio file
                MediaPlayer newMedia = MediaPlayer.create(view.getContext(), audioFiles.get(holderPhrase));
                newMedia.start();
                //Create a new intent with the selected phrase and provider phrase based on the position then send to the main activity to update the textviews
                Intent intent = new Intent(context, DisplayPhrases.class);
                intent.putExtra("PatientPhrase", phrases.get(finalPosition));
                intent.putExtra("ProviderPhrase", translatedProviderPhrases.get(finalPosition));
                intent.putExtra("AudioFile", holderPhrase);
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
        //Declare our variables
        OnNoteListener onNoteListener;
        public Button btn1;




        //Constructor that is called when class is created, sets the listener and the elements in the view
        public ViewHolder(@NonNull View itemView, OnNoteListener listener) {
            super(itemView);
            //Instantiate the variables
            this.onNoteListener = listener;
            itemView.setOnClickListener(this);
            btn1 =itemView.findViewById(R.id.btn1);



        }
        @Override  //onClick method that is called when a button is clicked
        public void onClick(View view) {
            try{
                onNoteListener.onNoteClick(getAdapterPosition()); //Allows the code to see what position the adapter was in when the button was clicked, telling us what phrase was selected
            }
            catch (Exception e){

            }
        }

        //Getter for the context (not used atm, may want to revisit later)
        public Context getApplicationContext() {
            return context.getApplicationContext();
        }
    }

    //OnNoteListener interface must be declared so it can be used in adapter
    public interface OnNoteListener{
        void onNoteClick(int position);
    }


}
