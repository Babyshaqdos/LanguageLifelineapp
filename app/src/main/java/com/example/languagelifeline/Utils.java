package com.example.languagelifeline;

import android.content.Context;
import android.widget.Toast;


//Helper class to make use of Toast messages
public class Utils {

    //Function to display a toast message
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show(); //Toast is the little message that will pop up at the bottom of the screen, main way of debugging in Android studio
    }

}
