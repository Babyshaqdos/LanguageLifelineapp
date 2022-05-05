package com.example.languagelifeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//Helper class to make use of Toast messages
public class Utils {
    //Function to display a toast message
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show(); //Toast is the little message that will pop up at the bottom of the screen, main way of debugging in Android studio
    }
    public static boolean isColorblind = true;
    private static FontTheme currentFontTheme = FontTheme.LARGE;
    private static int _currentTheme = R.style.CBAppThemeLarge;
    private static int _currentIndex = 0;

    public static void changeToTheme(AppCompatActivity activity, FontTheme fontTheme) {
        changeToTheme(activity, fontTheme, Utils.isColorblind);
    }
    public static void changeToTheme(AppCompatActivity activity, boolean isColorblind) {
        changeToTheme(activity, Utils.currentFontTheme, isColorblind);
    }
    public static void changeToTheme(AppCompatActivity activity, FontTheme fontTheme, boolean isColorblind) {
        // Set the font size for the entire app
        Utils.isColorblind = isColorblind;
        Utils.currentFontTheme = fontTheme;
        if (Utils.isColorblind) {
            switch (fontTheme) {
                case SMALL:
                    _currentTheme = R.style.CBAppThemeSmall;
                    _currentIndex = 0;
                    break;
                case MEDIUM:
                    _currentTheme = R.style.CBAppThemeMedium;
                    _currentIndex = 1;
                    break;
                case LARGE:
                    _currentTheme = R.style.CBAppThemeLarge;
                    _currentIndex = 2;
                    break;
            }
        } else {
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
        }

        activity.recreate();
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        // Change which font size for the screen
        activity.setTheme(_currentTheme);
    }

    public static int getCurrentIndex() {
        return _currentIndex;
    }


}
