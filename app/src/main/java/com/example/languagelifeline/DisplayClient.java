package com.example.languagelifeline;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.Socket;

import static android.os.Environment.DIRECTORY_MUSIC;
import static android.os.Environment.DIRECTORY_PICTURES;

public class DisplayClient extends AppCompatActivity{


    final Utils toasty = new Utils(); //Debugging messages
    private TextView recieveLang;
    private  TextView recievePhrase;
    private Button audioBtn;
    private ImageView recieveImage;
    private Button homebtn;
    private Button downloadBtn;
    String patient;
    private Button doneBtn;
    String phrase;
    String language;
    ReadFiles readFiles;
    private EditText ipField;
    private EditText portField;
    String ipAddress;
    String portNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientui);

        //Instantiate all of our UI elements
        recieveImage = (ImageView)findViewById(R.id.recievedImage);
        recieveLang = (TextView)findViewById(R.id.recievedLanguageView);
        recievePhrase = (TextView)findViewById(R.id.recievedPhraseView);
        audioBtn = (Button)findViewById(R.id.receivedAudiobtn);
        doneBtn = (Button)findViewById(R.id.doneBtn);
        homebtn = (Button)findViewById(R.id.clientHomebtn);
        downloadBtn = (Button)findViewById(R.id.downloadBtn);
        ipField = (EditText)findViewById(R.id.inputIPTxt);
        portField = (EditText)findViewById(R.id.inputPort);
        //Create our readFiles class for access to methods
        readFiles = new ReadFiles(this);
        Intent intent = getIntent();


        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    ipAddress = ipField.getText().toString();
                    portNumber = portField.getText().toString();
                    ConnectClient();
                }
                catch (Exception e){
                    toasty.showToast(getApplicationContext(), "Error: Invalid IP or Port Number");
                }
            }
        });
        //Call function to initiate connection with the stand alone server
     //   ConnectClient();

        //Set listener on home button to navigate back to language selection screen
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                intent.putExtra("FirstRun", "No");
                startActivity(intent);
            }
        });
        //Set listener on done button to navigate to phrase selection screen
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayPhrases.class);
                if (language == null){
                    language = "English";
                }
                intent.putExtra("Language", language);
                intent.putStringArrayListExtra("LanguageList", readFiles.getLanguages());
                startActivity(intent);
            }
        });
        //Set listener on audio button to allow user to replay audio file downloaded from server
        audioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String basedirectoryaudio = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) { //Eventually this needs to be reworked, current build is only for older OS
                    basedirectoryaudio = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC)); //Get the path for the music directory
                }
                basedirectoryaudio += "/LanguageLifeline"; //Need to create separate folder for LL music assets
                //Replace all spaces and punctuation
                String newAudioPhrase = phrase.replaceAll("\\s", "");
                String result = newAudioPhrase.replaceAll("\\p{Punct}", "");
                //Create new file path specific to downloaded phrase
                String fileNameAudio = basedirectoryaudio + File.separator + result + ".mp3";

                //Create media player with filepath of downloaded file
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(fileNameAudio));
                mediaPlayer.start(); //Play the media
               // System.out.println("Hopefully our audio played");
            }
        });

    }

    // driver code, creates socket connection and parses input. Handles input according to order server writes the input to the socket
    public boolean ConnectClient() {
        Thread thread = new Thread(new Runnable() { //Socket connections need to be handled on a separate thread or app will crash
        @Override
        public void run() {
         //   System.out.println("Attempting to make the connection");
            try {
             //   System.out.println("Before socket call");
                //Port number and Host number may need to be passed into this function for future compatability, will revisit later

                Socket socket = new Socket(ipAddress, Integer.parseInt(portNumber));
             //   System.out.println("After socket call");

                //Create our data input stream that gathers from the socket output
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                boolean flag = true; //Generic flag value to control our reading from the socket
                while(flag){
                    String line = dis.readUTF(); //Grabs the next key from socket
                    switch (line){ //Conditional check of our key value, tells us how to handle next data packet in socket
                        case "Patient":
                            String locPatient = dis.readUTF();
                            patient = locPatient;
                            break;
                        case "Language":
                            //"Language" key value found
                            String locallanguage = dis.readUTF(); //Read the next value from socket, should be value of "Language"
                            language = locallanguage; //Set a class variable equal to language key value for reference on the main thread
                            break;
                        case "Phrase":
                            //"Phrase" key value found
                            String localphrase = dis.readUTF(); //Read next value from socket, should be value of "Phrase"
                            phrase = localphrase; //Set a class variable equal to phrase key value for reference on main thread
                         //   readFiles.writePhrase(language, patient, phrase);
                            break;
                        case "Image":
                            //Key value of image was found, next value in dis will be size of image byte array
                            int numBytes = dis.readInt();
                            byte[] byteAr = new byte[numBytes]; //Create a byte array of size equal to last key value
                            String basedirectory2 = null;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) { //Again, revisit later
                                basedirectory2 = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES)); //Get file path for pictures folder
                            }
                            basedirectory2 += "/LanguageLifeline"; //Add LanguageLifeline to path
                            //Replace all spaces and punctuation from filepath
                            String newPhrase = phrase.replaceAll("\\s", "");
                            String result = newPhrase.replaceAll("\\p{Punct}", "");
                            String fileName2 = basedirectory2 + File.separator + result + ".png";
                            File file = new File(fileName2);
                            file.getParentFile().mkdir();
                            file.createNewFile();
                            //Open a fileOutputStream on the filepath from above, this will create the file if it doesnt exist. Allows us to write to file
                            FileOutputStream fos = new FileOutputStream(file);
                            //Encapsulate our file output stream in a buffer to handle our buffered data from socket
                            BufferedOutputStream bos = new BufferedOutputStream(fos);
                            int bToRead = 0; //Bytes left to read
                            while (numBytes > 0){ //Loop through reading the socket into our byte array
                                if ( numBytes > byteAr.length){
                                    bToRead = byteAr.length;
                                }
                                else{
                                    bToRead = numBytes;
                                }
                                int bytesRead = dis.read(byteAr, 0, bToRead);
                                if (bytesRead > 0){
                                    bos.write(byteAr, 0, bytesRead);
                                    numBytes -= bytesRead;
                                }
                                if ( bytesRead == -1){
                                    break;
                                }
                            }
                            bos.close(); //Close the stream
                            Bitmap bmp = null;
                            //Opens a file input stream which allows us to read the byte array from file and parse into a bitmap, which can be used to display image in app
                            FileInputStream fis = new FileInputStream(fileName2);
                            try{
                                bmp = BitmapFactory.decodeStream(fis);
                                Bitmap finalBmp = Bitmap.createScaledBitmap(bmp, 36,36, true);
                                runOnUiThread(new Runnable() { //Modifying UI elements cannot be done on 2nd thread, must be run on main thread
                                    @Override
                                    public void run() {
                                        //Set our UI elements with our received data for validation purposes by user
                                        recieveImage.setImageBitmap(finalBmp);
                                        recievePhrase.setText(phrase);
                                        recieveLang.setText(language);
                                        readFiles.addLanguage(language);
                                        readFiles.writePhrase(language, patient, phrase);
                                    }
                                });
                            }
                            finally {
                                //Close the stream
                                fis.close();
                            }
                            break;
                        case "Audio": //Audio key found
                            int numAudioBytes = dis.readInt(); //Get the number of bytes of audio file
                            byte[] audioBytes = new byte[numAudioBytes]; //Create byte array of size equal to last key value
                            String basedirectoryaudio = null;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                                basedirectoryaudio = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC)); //Get file path for music directory
                            }
                            basedirectoryaudio += "/LanguageLifeline"; //Add languagelifeline to path
                            //Replace all spaces and punctuation from filepath
                            String newAudioPhrase = phrase.replaceAll("\\s", "");
                            String result2 = newAudioPhrase.replaceAll("\\p{Punct}", "");
                            String fileNameAudio = basedirectoryaudio + File.separator + result2 + ".mp3";
                            File file2 = new File(fileNameAudio);
                            file2.getParentFile().mkdir();
                            file2.createNewFile();
                            //Open a fileOutputStream on the filepath from above, this will create the file if it doesnt exist. Allows us to write to file
                            FileOutputStream fos2 = new FileOutputStream(file2);
                            //Encapsulate our file output stream in a buffer to handle our buffered data from socket
                            BufferedOutputStream bos2 = new BufferedOutputStream(fos2);
                            int bytesToRead = 0; //Bytes left to read
                            while (numAudioBytes > 0){ //Loop through reading the socket into our byte array
                                if ( numAudioBytes > audioBytes.length){
                                    bytesToRead = audioBytes.length;
                                }
                                else{
                                    bytesToRead = numAudioBytes;
                                }
                                int bytesRead2 = dis.read(audioBytes, 0, bytesToRead);
                                if (bytesRead2 > 0){
                                    bos2.write(audioBytes, 0, bytesRead2);
                                    numAudioBytes -= bytesRead2;
                                }
                                if ( bytesRead2 == -1){
                                    break;
                                }
                            }
                            //Close our streams
                            bos2.close();
                            fos2.close();
                            break;
                        case "exit": //exit key value found, safe to end connection
                            flag = false; //Set flag to false so we break out of our loop
                            dis.close(); //Close our stream
                            break;
                        default: //Should not reach this but if it does, will break loop and close stream
                            flag = false;
                            dis.close();
                            break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
    });
        thread.start();
        return true;

    }




}
