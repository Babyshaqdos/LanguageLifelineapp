package com.example.languagelifeline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


//This is your main class that is called when the application is started
public class Welcome extends AppCompatActivity {
    final Utils toasty = new Utils();

    //All classes that contain the code to display the UI will need to have an onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome); //This line will change the displayed UI to whichever layout file you specify

        Button engBtn = (Button)findViewById(R.id.firstlangbtn);
        Button frenchBtn = (Button)findViewById(R.id.secondlangbtn);
        Button spanishBtn = (Button)findViewById(R.id.thirdlangbtn);

        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayPhrases.class);
                intent.putExtra("Language", "English");
                toasty.showToast(view.getContext(), "English button debug msg");
                startActivity(intent);
            }
        });

        frenchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayPhrases.class);
                intent.putExtra("Language", "French");
                startActivity(intent);
            }
        });

        spanishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayPhrases.class);
                intent.putExtra("Language", "Spanish");
                startActivity(intent);
            }
        });
        //If you have any buttons, text fields, pictures, etc on the UI then this is where you will want to first create and instantiate the object
        //For example if we have a button on our UI it may look something like this
        /*
            Button loginButton =(Button)findViewById(R.id.loginButton);
        */
        //Note: You will use findViewById to instantiate all objects on your UI so when you create UI be sure to use distinct names for the objects so you can easily find them here


        //If we want to move between UI screens we can use objects called intents, these are objects that can contain as many variables as needed to share between classes
        /*
            Intent newIntent = new Intent(context, ClassYouWantToMoveTo.class)
        */
        //The first argument, context, is the current class or view level that you are in. This comes into play when we nest intents inside something called listeners


        //Listeners are what we use to monitor events inside the app. For example an onClickListener set on a button will trigger the code inside of it whenever that button is clicked on
        //For example, lets say we want to change the UI screen when the LoginButton is clicked
        /*
            LoginButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    Intent newIntent = new Intent(view.getContext(), UIScreen2.class);
                    newIntent.putExtra("FirstVariableStringValue", "This is our string value"); //This line lets us add variables to the intents in order to share across classes, be sure to remember how you name the variables
                    newIntent.putExtra("SecondVariableIntValue", 10); //Intents can hold as many variables as needed and they can all be different data types
                    startActivityForResult(newIntent, 0);
                }
            }   //On the UIScreen2 class I will show how to accept the intents and access the variables
         */

    }
}