package com.example.languagelifeline;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<ScrollingAdapter.ViewHolder> {

    private List<String> languages;
    private ScrollingAdapter.OnNoteListener mOnNoteListener;
    private Context context;
    String myJson;
    ReadFiles readFiles;

    public LanguageAdapter(Context context, List<String> lang, ReadFiles readFiles){
        this.context = context;
        this.languages = lang;
        this.readFiles = readFiles;
    }


    @NonNull
    @Override
    public ScrollingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phraselistui, parent, false);
        return new ScrollingAdapter.ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollingAdapter.ViewHolder holder, int position) {
        final Utils toasty = new Utils(); //Class that holds our toast message function (used for debugging purposes)

        holder.btn1.setText(languages.get(position)); //Holder is the viewgroup containing the phraselistui layout, line sets the button text based on the position in the phrases
        int finalPosition = position;
        holder.btn1.setOnClickListener(new View.OnClickListener() { //Set an onclick listener to the button
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayPhrases.class);
                intent.putExtra("Language", languages.get(position));
                intent.putStringArrayListExtra("LanguageList", (ArrayList<String>) languages);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languages.size();
    }




    //Viewholder class that actually extends the recyclerview and implements the listener
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Declare our variables
        ScrollingAdapter.OnNoteListener onNoteListener;
        public Button btn1;


        //Constructor that is called when class is created, sets the listener and the elements in the view
        public ViewHolder(@NonNull View itemView, ScrollingAdapter.OnNoteListener listener) {
            super(itemView);
            //Instantiate the variables
            this.onNoteListener = listener;
            itemView.setOnClickListener(this);
            btn1 = itemView.findViewById(R.id.btn1);


        }

        @Override  //onClick method that is called when a button is clicked
        public void onClick(View view) {
            try {
                onNoteListener.onNoteClick(getAdapterPosition()); //Allows the code to see what position the adapter was in when the button was clicked, telling us what phrase was selected
            } catch (Exception e) {

            }
        }

        //Getter for the context (not used atm, may want to revisit later)
        public Context getApplicationContext() {
            return context.getApplicationContext();
        }
    }

    //OnNoteListener interface must be declared so it can be used in adapter
    public interface OnNoteListener {
        void onNoteClick(int position);
    }


}
