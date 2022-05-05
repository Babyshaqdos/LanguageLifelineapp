package com.example.languagelifeline;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;

import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static android.os.Environment.DIRECTORY_PICTURES;

public class Client extends AsyncTask<Void,Void, Void> {

    static List<String> languages;
    List<String> phrases;
    Context context;
    static ArrayList<ArrayList<String>> morephrases;
    String filepath;
    private byte [] imgbyte;
    DisplayClient displayClient;
    Intent intent;
    Bitmap bitmap;
    ReadFiles readFiles;

    public Client(Context Context){
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("French");
        languages.add("Spanish");
        phrases = new ArrayList<>();
        context = Context;
        //readFiles = new ReadFiles(context);
        morephrases = new ArrayList<ArrayList<String>>();
        for (int i =0; i < languages.size(); i++){
            ArrayList<String> ai = new ArrayList<String>();
            ai.add(languages.get(i));
            morephrases.add(ai);
        }
       // intent = new Intent(context, DisplayClient.class);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        System.out.println("Testing our doinbackground function");
        if (ConnectClient()){
            return null;
        }
        else{
            System.out.println("Our connect client returned null for some fucking reason");
            return null;
        }
    }

/*
    Client(Context Context){
        languages = new ArrayList<>();
        languages.add("English");
        languages.add("French");
        languages.add("Spanish");
        phrases = new ArrayList<>();
        context = Context;
        morephrases = new ArrayList<ArrayList<String>>();
        for (int i =0; i < languages.size(); i++){
            ArrayList<String> ai = new ArrayList<String>();
            ai.add(languages.get(i));
            morephrases.add(ai);
        }
    } */


    // driver code
    public boolean ConnectClient()
    {

      //  toasty.showToast(context, "Testing");



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // toasty.showToast(context, "Testing in thread outside try");
                System.out.println("Debug message just inside the run thread");
                synchronized (context) {
                    try {
                        //  toasty.showToast(context, "Testing just inside try before socket");
                        Socket socket = new Socket("192.168.1.6", 4200);
                        //  toasty.showToast(context, "Testing just after socket");
                        // writing to server
                        PrintWriter out = new PrintWriter(
                                socket.getOutputStream(), true);

                        // reading from server
                        BufferedReader in
                                = new BufferedReader(new InputStreamReader(
                                socket.getInputStream()));

                        // object of scanner class
                        Scanner sc = new Scanner(System.in);
                        String line = null;

                        // toasty.showToast(context, "Testing inside the thread");

                        Intent intent = new Intent();
                        Intent in1 = new Intent(context, DisplayClient.class);

                        String language = "";
                        String phrase = "";

                        InputStream inputStream = socket.getInputStream();

                        while (!"exit".equalsIgnoreCase(line)) {
                            // reading from user
                            line = in.readLine();

                            //    toasty.showToast(context, line);
                            System.out.println(line);
                            if (line == null) {
                                System.out.println("Our line is null aka we read all our socket information already");
                                break;
                            }

                            switch (line) {
                                case "Language":
                                    //do something
                                    line = in.readLine();
                                    System.out.println(line);
                                    intent.putExtra("Language", line);
                                    language = handleLanguage(line);
                                    language = line;
                                    break;
                                case "Phrase":
                                    //do something
                                    line = in.readLine();
                                    intent.putExtra("Phrase", line);
                                    System.out.println(line);
                                    phrase = line;
                                    break;
                                case "Image":
                                    String filename = phrase + ".jpeg";
                                    String basedirectory = null;
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                                        basedirectory = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES));
                                    }
                                    String fileName = basedirectory + File.separator + filename;


                                    byte[] bSize = new byte[4];
                                    int offset = 0;
                                    while (offset < bSize.length){
                                        //   System.out.println("offset is " + offset);
                                        int bRead = inputStream.read(bSize, offset, bSize.length - offset);
                                        //  System.out.println("bSize is " + bSize);
                                        //  System.out.println("Our offset is " + offset);
                                        offset += bRead;
                                    }

                                    int filesize;
                                    filesize = (int) (bSize[0] & 0xff) << 24
                                            | (int) (bSize[1] & 0xff) << 16
                                            | (int) (bSize[2] & 0xff) << 8
                                            | (int) (bSize[3] & 0xff);

                                    byte[] data = new byte[4*1024];
                                    int bToRead;
                                    FileOutputStream fos = new FileOutputStream(fileName);
                                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                                    while (filesize > 0){
                                        System.out.println(filesize + " and data.length " + data.length);
                                        if ( filesize > data.length){
                                            bToRead = data.length;
                                        }
                                        else{
                                            bToRead = filesize;
                                        }
                                        int bytesRead = inputStream.read(data, 0, bToRead);
                                        System.out.println("Our bytesRead is : " + bytesRead);
                                        System.out.println("Our data after being written to is " + data + " with length " + data.length);
                                        if (bytesRead > 0){
                                            bos.write(data, 0, bytesRead);
                                            filesize -= bytesRead;
                                        }
                                        if ( bytesRead == -1){
                                            break;
                                        }
                                    }
                                    //  bos.close();
                                      System.out.println("Our data is now " + data.toString());


                                    Bitmap bmp = null;
                                    FileInputStream fis = new FileInputStream(fileName);
                                    try{
                                        bmp = BitmapFactory.decodeStream(fis);
                                        bitmap = bmp;
                                       // Bitmap finalBmp = bmp;
                                      //  displayClient.runOnUiThread(finalBmp);

                                    }
                                    finally {
                                        //  fis.close();
                                    }
                               /*     byte[] sizeAr = new byte[15000]; //Create array to hold num of bytes
                                    inputStream.read(sizeAr); //Read the size of the input stream into bytes array
                                    System.out.println("Our inputstream sizeAr is : " + sizeAr.length);
                                    int imageSize = ByteBuffer.wrap(sizeAr).asIntBuffer().get(); //Get the size of the image
                                    byte[] imageAr = new byte[imageSize]; //Create a new buffer byte array with size of image
                                    while (true) { //Debugging is skipping everything past this point -- why????
                                        //Is our line variable reading to the end of the socket while debugging? Asynchronous issue?
                                        int bytesRead = inputStream.read(imageAr);
                                        System.out.println("Looping through the reading of the socket into inputStream " + bytesRead);
                                        if (bytesRead < 0) {
                                            break;
                                        } //Change this to a do_while() loop, might be better computationally and potentially easier to debug
                                       // Thread.sleep(10);
                                    } */
                                    //     inputStream.read(imageAr); //Read the image into the byte array
                              //      System.out.println("Our inputstream imageAr is : " + imageAr.length);
                                 //  bitmap = receiveFile(inputStream, phrase + ".jpg");
                                    //    System.out.println(imageAr +" "+ imageSize);
                                    //Bitmap bmp = null;
                                    //    Bitmap bmp = createBitmap(imageAr, imageSize);
                                    // I dont know where its all fucked at, but its all fucked. Bitmap is not being created properly
                                    // Either I am not passing the bytes correctly or its running to fast for bitmap to be created.
                                    //  ByteBuffer byteBuffer = ByteBuffer.wrap(imageAr);
                                    // byteBuffer.rewind();
                                    // bmp.copyPixelsFromBuffer(byteBuffer);
                                    //   Bitmap bmp = BitmapFactory.decodeStream(inputStream);
                                    //  Bitmap bmp = BitmapFactory.decodeByteArray(imageAr, 0, imageSize); //convert byte array into bitmap
                            /*    while(true){
                                    System.out.println("Looping through while waiting for bitmap to finish");
                                    if (bmp != null){
                                        break;
                                    }
                                } */
                        /*            Bitmap bmp = BitmapFactory.decodeByteArray(imageAr, 0, imageAr.length); //convert byte array into bitmap
                                          System.out.println("Our bitmap is : " + bmp);
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    while (stream == null) {
                                        System.out.println("This is all fucked");
                                    }
                                    if (bmp == null) {
                                        System.out.println("This is fucked even more");
                                    } else {
                                        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                                    }
                                    byte[] byteArray = stream.toByteArray();
                                    String encodeImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
                                    System.out.println("Our byte array is : " + byteArray.toString());
                                    in1.putExtra("Bitmap", byteArray);
                                    in1.putExtra("encodeImage", encodeImage); */



                                    //  Thread.interrupted();


                                /*   bitmap = bmp;
                                while(bmp == null){

                                }
                                if ( bmp == null ){
                                    System.out.println("our bitmap is null right after decodying byte array fuck my life");
                                }
                                else{
                                    savebitmap(getBytesFromBitmap(bmp), intent);
                                }
                                  System.out.print("Our bitmap is :" + bmp.toString());
                                intent.putExtra("Bitmap", getBytesFromBitmap(bmp));
                                String finalLanguage = language;
                                String finalPhrase = phrase; */

                                    //   Log.d("Client", String.valueOf((bmp==null)));
                       /*        try{
                                   savebitmap(bmp, intent);
                                   //       recieveImage.setImageBitmap(bmp);
                             //      recieveImage.setImageBitmap(bmp);
                               //    savebitmap(bmp, intent);
                                   System.out.println("Our bitmap should be displayed now");
                               } catch (Exception e){
                                   System.out.println("Bitmap is super fucked up ");
                                   e.printStackTrace();
                               } */
                                    //  savebitmap(bmp); //Send bitmap to function to save
                                    break;
                                case "Audio":
                             //       DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); //Get the input from the socket and parse into datainputstream
                             //       int numBytes = inputStream.available(); //Get the number of bytes in the input stream
                             //       byte[] audioData = new byte[numBytes]; //Create byte array with number of byte in stream
                              //      int bytes = dataInputStream.read(audioData); //Read the stream into the bytes array and save number of bytes
                                    //    saveAudio(audioData); //Parse bytes array into function to save

                                    break;
                                default:
                                    //Shit went wrong, fix
                                    System.out.println("Default case in switch reached (this shouldnt happen)");
                                    in.close();
                                    break;


                            }
                            out.flush();

                        }

                        // closing the scanner object
                        //sc.close();
                        readFiles.writePhrase(language, "Patient", phrase);
                     //   in1.putExtra("Bitmap", byteArray);
                //        in1.putExtra("FirstRun", "False");
                      //  System.out.println("Our byteArray is " + byteArray.length);
                        System.out.println("We are heading from client to displayclient");
                      //  context.startActivity(in1);
                        //   return true;
                    } catch (IOException e) {
                        //    return false;
                        //   toasty.showToast(context, "Problem with our socket boss");
                        e.printStackTrace();
                        System.out.println("Problem with our socket boss");
                    }
                }
            }
        });
        thread.start();
        // establish a connection by providing host and port
        // number

       /* try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
        return true;
    }


    //Function to handle the input from socket if the input is the language
    public static String handleLanguage(String line){
        if (languages.contains(line)){ //Checks if languages contains the specificied language (will revisit later - may put languages inside txt file)
            return line;
        }
        else {
            languages.add(line);
            ArrayList<String> newLang = new ArrayList<String>();
            newLang.add(line);
            morephrases.add(newLang);
            return line;
        }
    }


    public static boolean handlePhrase(String line, String language){
        for (int k = 0; k < morephrases.size(); k++){
            if (morephrases.get(k).get(0).equals(language)){
                morephrases.get(k).add(line);
                return true;
            }
        }
        return false;
    }
    public Bitmap receiveFile(InputStream is, String filename) throws IOException {
        String basedirectory = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            basedirectory = String.valueOf(Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES));
        }
        String fileName = basedirectory + File.separator + filename;


        byte[] bSize = new byte[4];
        int offset = 0;
        while (offset < bSize.length){
            //   System.out.println("offset is " + offset);
            int bRead = is.read(bSize, offset, bSize.length - offset);
            //  System.out.println("bSize is " + bSize);
            //  System.out.println("Our offset is " + offset);
            offset += bRead;
        }

        int filesize;
        filesize = (int) (bSize[0] & 0xff) << 24
                | (int) (bSize[1] & 0xff) << 16
                | (int) (bSize[2] & 0xff) << 8
                | (int) (bSize[3] & 0xff);

        byte[] data = new byte[bSize.length * 4];
        int bToRead;
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        while (filesize > 0){
            if ( filesize > data.length){
                bToRead = data.length;
            }
            else{
                bToRead = filesize;
            }
            int bytesRead = is.read(data, 0, bToRead);
            if (bytesRead > 0){
                bos.write(data, 0, bytesRead);
                filesize -= bytesRead;
            }
            if ( bytesRead == -1){
                break;
            }
            //  System.out.println("Our data is now " + data);
        }
      //  bos.close();

        Bitmap bmp = null;
        FileInputStream fis = new FileInputStream(fileName);
        try{
            bmp = BitmapFactory.decodeStream(fis);

            return bmp;
        }
        finally {
          //  fis.close();
        }
    }


    public File savebitmap(Bitmap bmp, Intent intent) throws IOException{
        intent.putExtra("FirstRun", "False");
        System.out.println("Starting a new intent");
        if (bmp == null){
            System.out.println("our bitmap is null wtf");
        }
        else{
            if (displayClient == null){
                System.out.println("Our class displayClient is null");
            }
            else{
                intent.setAction(Intent.ACTION_RUN);
               context.startActivity(intent);
            }
        }
        //  recieveImage.setImageBitmap(bmp);
     /*   filepath = "/sdcard/small.jpg";
        File imageFile = new File(filepath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imageFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
         //   e.printStackTrace();
        }

        Bitmap bm = BitmapFactory.decodeStream(fis);
        imgbyte = getBytesFromBitmap(bm); */
      //  recieveImage.setImageBitmap(bm);
      /*  ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes); //May want to switch to PNG as it is lossless but images are small so compression may not be an issue
        //Adjust this file path based on the language
        File f = new File(Environment.getExternalStorageDirectory()
                + File.separator + "testimage.jpg");
        f.createNewFile();
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(bytes.toByteArray());
        fo.close(); */
       // return imageFile;
        return null;
    }

    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try{
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        }
        catch (Exception e){
            System.out.println("bitmap fucked sir");
        }
        return stream.toByteArray();
    }

    public static boolean saveAudio(byte[] audioAr){
        //Will need to adjust the path for this as well
        final File soundFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "AudioRecording/");
        soundFile.mkdirs();
        final File outFile = new File(soundFile, "audiofile.mp3"); //Adjust path based on the language

        try {
            final FileOutputStream output = new FileOutputStream(outFile);
            output.write(audioAr);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
