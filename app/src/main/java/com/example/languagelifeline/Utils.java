package com.example.languagelifeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


//Helper class to make use of Toast messages
public class Utils {
    private static int _currentTheme = R.style.AppThemeMedium;
    private static int _currentIndex = 0;
    //Function to display a toast message
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show(); //Toast is the little message that will pop up at the bottom of the screen, main way of debugging in Android studio
    }

    public static void changeToTheme(Activity activity, FontTheme fontTheme) {
        // Set the font size for the entire app
        switch (fontTheme) {
            case SMALL:
                _currentTheme = R.style.AppThemeSmall;
                _currentIndex = 0;
                break;
            case MEDIUM:
                _currentTheme = R.style.AppThemeMedium;
                _currentIndex = 1;
                break;
            case LARGE:
                _currentTheme = R.style.AppThemeLarge;
                _currentIndex = 2;
                break;
        }

        // Reopen the window that was already open
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        // Change which font size for the screen
        activity.setTheme(_currentTheme);
    }

    public static int getCurrentIndex() {
        return _currentIndex;
    }


}
