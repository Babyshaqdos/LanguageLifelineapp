package com.example.languagelifeline;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.os.Environment.DIRECTORY_MUSIC;
import static android.os.Environment.DIRECTORY_PICTURES;


//Adapter class that can handle the recycler view and repopulate it with each scroll
public class ScrollingAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {

    //Declare our local variables and objects
    private static Context context;
    private List<String> phrases;
    private List<String> providerPhrases;
    private List<String> translatedProviderPhrases;
    private OnNoteListener mOnNoteListener;
    private String language;
    private String user;

    int[] pictures = {R.drawable.i_need_to_use_the_restroom, R.drawable.i_would_like_some_food, R.drawable.i_would_like_some_water, R.drawable.what_is_this, R.drawable.my_pain_is_better,
            R.drawable.my_pain_is_worse, R.drawable.my_pain_has_stayed_the_same, R.drawable.my_stomach_hurts, R.drawable.i_am_dizzy, R.drawable.i_do_not_feel_good,
            R.drawable.i_feel_weak, R.drawable.i_am_having_trouble_breathing, R.drawable.i_feel_nauseous, R.drawable.i_think_i_have_a_fever, R.drawable.can_you_check_my_vitals,
            R.drawable.can_you_charge_my_phone, R.drawable.i_need_to_make_a_phone_call, R.drawable.can_you_close_my_blinds, R.drawable.can_you_open_my_blinds
            , R.drawable.i_cannot_sleep, R.drawable.i_would_like_some_medication_to_help_me_sleep, R.drawable.can_i_have_a_pillow, R.drawable.can_i_have_a_blanket,
            R.drawable.can_i_move_to_the_chair, R.drawable.can_i_raise_my_head, R.drawable.can_i_lower_my_head, R.drawable.can_i_change_my_position, R.drawable.i_feel_uncomfortable
            , R.drawable.i_would_like_to_do_that_myself, R.drawable.i_would_like_that_later, R.drawable.may_i_see_the_nurse};
    private Map<String, Integer> audioFiles;
    ReadFiles readFiles;

    //Constructor that takes the current context, list of phrases for both provider and patient, the current language, whether the user is a patient or provider, and a map of the audiofiles
    public ScrollingAdapter(Context context, List<String> phrases, String language, String user, List<String> providerPhrases, Map<String, Integer> audioFiles, List<String> translatedProviderPhrases, ReadFiles readFiles){
        this.phrases= phrases;
        this.context=context;
        this.language = language;
        this.user = user;
        this.providerPhrases = providerPhrases;
        this.audioFiles = audioFiles;
        this.translatedProviderPhrases = translatedProviderPhrases;
        this.readFiles = readFiles;

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
    try{
        Drawable icon = context.getResources().getDrawable(context.getResources().getIdentifier(String.valueOf(pictures[position]), "drawable", context.getPackageName()));
        icon.setBounds(0,0,0,0);
        holder.btn1.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null);
    }
    catch (Exception e){
        try {
            String basedirectory2 = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) { //Again, revisit later
                basedirectory2 = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES)); //Get file path for pictures folder
            }
            basedirectory2 += "/LanguageLifeline"; //Add LanguageLifeline to path
            //Replace all spaces and punctuation from filepath
            String locPhrase = phrases.get(position);
            System.out.println("Our locPhrase = " + locPhrase);
            String newPhrase = locPhrase.replaceAll("\\s", "");
            String result = newPhrase.replaceAll("\\p{Punct}", "");
            String fileName2 = basedirectory2 + File.separator + result + ".png";
            File file = new File(fileName2);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
            Bitmap scaledBM = Bitmap.createScaledBitmap(bm, 36, 36, true);
            Drawable draw = new BitmapDrawable(context.getApplicationContext().getResources(), scaledBM);
            draw.setBounds(0,0,0,0);
            holder.btn1.setCompoundDrawablesWithIntrinsicBounds(null, null, draw, null);
        }
        catch (Exception eh){

        }
    }
        holder.btn1.setText(phrases.get(position)); //Holder is the viewgroup containing the phraselistui layout, line sets the button text based on the position in the phrases
        int finalPosition = position;
        holder.btn1.setOnClickListener(new View.OnClickListener() { //Set an onclick listener to the button
            @Override
            public void onClick(View view) {
                String holderPhrase = phrases.get(finalPosition); //Get the phrase using our final int
              //  toasty.showToast(context, holderPhrase);
                //Create a media player object and pass in the correct audio file
                try {
                    MediaPlayer newMedia = MediaPlayer.create(view.getContext(), audioFiles.get(holderPhrase));
                    newMedia.start();
                }
                catch (Exception e){
                    String basedirectoryaudio = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        basedirectoryaudio = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC)); //Get file path for music directory
                    }
                    basedirectoryaudio += "/LanguageLifeline"; //Add languagelifeline to path
                    //Replace all spaces and punctuation from filepath
                    String newPhrase = phrases.get(finalPosition);
                    String newAudioPhrase = newPhrase.replaceAll("\\s", "");
                    String result2 = newAudioPhrase.replaceAll("\\p{Punct}", "");
                    String fileNameAudio = basedirectoryaudio + File.separator + result2 + ".mp3";
                    try {
                        MediaPlayer newMedia = MediaPlayer.create(view.getContext(), Uri.parse(fileNameAudio));
                        newMedia.start();
                    } catch (Exception eh){

                    }
                }
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
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
