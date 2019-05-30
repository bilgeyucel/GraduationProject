package com.example.grad;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.StringRequest;
import com.github.pavlospt.CircleView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.arch.lifecycle.ViewModelProviders;

import com.jcraft.jsch.*;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
//    ImageView image_photo;
    public static final String KEY = "ourKey";
    public static final String RECOGNIZED_KEY = "RECOGNIZED_KEY";
    private MainViewModel viewModel;


    private String encodedString;
    private String filename;
    public long timeBeforeUpload;
    public long fileSize;

    private String solution = "Wait for server to finish :)";
    private String recognized = "";
    public String currentPhotoPath;
    public Uri photoURI;
    public TextView startView;
    public Button print_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Button take_photo = findViewById(R.id.take_photo);
        startView = findViewById(R.id.startView);
        print_result = findViewById(R.id.print_result);
        print_result.setVisibility(View.INVISIBLE);
//        image_photo = findViewById(R.id.image_photo);



        //disable the button if the user doesnt have camera
        if(!hasCamera()){
            take_photo.setEnabled(false);
//            print_result.setEnabled(false);

        }
        //Onceki State ile alakali bir yerler belki silinebilir baslangic

        if(savedInstanceState != null){
            viewModel.readFromBundle(savedInstanceState);
        }else{
            System.out.println("buraya girdim");
        }

        //Onceki State ile alakali bir yerler belki silinebilir bitti */

//        print_result.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent intent = new Intent(getApplicationContext(),PrintActivity.class);
//                intent.putExtra(KEY, solution);
//                startActivity(intent);
//            }
//        });
        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

    }

    //check if the user has a camera
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //launching the camera
    public void launchCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //take a picture and pass results along to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
    public static String encodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality)
    {
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }
    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
                Log.d("grad", photoFile.toString());
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name

        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = new File(storageDir +"/yenihal.png");



        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //if you want to return the image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            try{Bitmap photo = MediaStore.Images.Media.getBitmap(getContentResolver(), photoURI);
//                image_photo.setImageBitmap(photo);
 }
            catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

            print_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(),PrintActivity.class);
                    intent.putExtra(KEY, solution);
                    startActivity(intent);
                }
            });

            new DownloadImageTask().execute("http://134.209.226.2:5000/api/photoSend");
        }
    }


    private String TAG = "grad";
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, this.getLocalClassName()+" : onResume called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, this.getLocalClassName()+" : onRestart called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, this.getLocalClassName()+" : onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, this.getLocalClassName()+" : onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, this.getLocalClassName()+" : onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        viewModel.writeToBundle(outState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //Log.d("CS310", "on new intent called");
        solution = intent.getExtras().getString(KEY);
    }

    boolean foundSolution;
    private class DownloadImageTask extends AsyncTask <String, Integer, String> {
        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            startView.setText("The photo is being sent to the server");
            print_result.setVisibility(View.INVISIBLE);

        }

        @Override
        protected String doInBackground(String... urls) {

            FileInputStream fis = null;
            try {
                JSch ssh = new JSch();
                foundSolution = false;
                Session session = ssh.getSession("grad", "134.209.226.2", 22);
                // Remember that this is just for testing and we need a quick access, you can add an identity and known_hosts file to prevent
                // Man In the Middle attacks
                java.util.Properties config = new java.util.Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);
                session.setPassword("kadircaneksi");
                //session.setTimeout();
                session.connect(5000);
                Channel channel = session.openChannel("sftp");
                channel.connect();
                Log.d("grad", "sftp girmis");
                ChannelSftp sftp = (ChannelSftp) channel;

                sftp.cd("/home/grad/sudokuSolver/sudoku-examples");
                sftp.put("/storage/emulated/0/Android/data/com.example.grad/files/Pictures/yenihal.png", "yenihal.jpg");
//                Log.d("grad", "sftp bayagi girmis");
                Boolean success = true;

                if(success){
                    URL obj = new URL(urls[0]);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", "Mozilla/5.0");
                    int responseCode = con.getResponseCode();
                    System.out.println("GET Response Code :: " + responseCode);
                    if (responseCode == HttpURLConnection.HTTP_OK) { // success
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                con.getInputStream()));
                        String inputLine,str="";
                        StringBuffer response = new StringBuffer();

                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        solution = response.toString();

                        in.close();
                        foundSolution = true;
                        // print result
                        return response.toString();
                    } else {
                        solution = "photo is not recognized as a sudoku";
                        System.out.println("GET request not worked");
                    }
                }

                channel.disconnect();
                session.disconnect();
            } catch (JSchException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (SftpException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            catch(Exception e){System.out.println("Request not worked");}
            return "bilge";
        }

        @Override
        protected void onPostExecute(String r) {
            if (foundSolution==true) {
                startView.setText("You may press the print result button to see the solution or take a hint now!");
                print_result.setVisibility(View.VISIBLE);
            }
            else{
                startView.setText("There is a problem with the server, please try it again!");
            }
        }
    }

}


