package com.example.grad;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import it.sauronsoftware.ftp4j.FTPClient;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView image_photo;
    public static final String KEY = "ourKey";
    private MainViewModel viewModel;


    private String encodedString;
    private String filename;
    public long timeBeforeUpload;
    public long fileSize;

    private CircleView circularProgress;
    private ServerImageObject imageObject;
    private RequestQueue queue;
    private static String POST_PARAMS = "image=";
    private String solution = "You have not taken a photo yet";
    TextView tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Button take_photo = findViewById(R.id.take_photo);
        Button print_result = findViewById(R.id.print_result);
        image_photo = findViewById(R.id.image_photo);
        tw = findViewById(R.id.printView);


        //disable the button if the user doesnt have camera
        if(!hasCamera()){
            take_photo.setEnabled(false);
            print_result.setEnabled(false);

        }
        /*  Onceki State ile alakali bir yerler belki silinebilir baslangic

        if(savedInstanceState != null){
            viewModel.readFromBundle(savedInstanceState);
        }else{
            viewModel.setRating("");
        }

        Onceki State ile alakali bir yerler belki silinebilir bitti */

        print_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PrintActivity.class);
                intent.putExtra(KEY, solution);
                startActivity(intent);
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

    //if you want to return the image taken
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
           // get the photo
           Bundle extras = data.getExtras();
           Bitmap photo = (Bitmap) extras.get("data");
           image_photo.setImageBitmap(photo);

           // http things
           String s = encodeToBase64(photo,Bitmap.CompressFormat.PNG,100);
           int length = s.length();
           Log.d("COMPRESS", Integer.toString(length));
           POST_PARAMS = POST_PARAMS + s;

//         loadImageFromStorage("data/data/com.example.grad/app_imageDir");
//         new DownloadImageTask().execute("http://134.209.226.2:5000/api/photoSend");
           new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String... params) {
                    int port = 5000;
                    String server = "134.209.226.2";
                    String username = "grad";
                    String password = "kadircaneksi";
                    String localPath = "data/data/com.example.grad/app_imageDir/"; //yerel depodaki ftp'ye yükleyeceğiniz dosyanın yolu
                    String remotePath = "/home/grad/grad_project/sudokuSolving/sudoku-examples"; //ftp'deki yolumuz
                    String newDirectory = "/"; //yeni oluşturacağımız klasörümüz

                    FTPClient ftpClient = new FTPClient(); //ftp clientimiz
                    File file = new File(localPath); //yükleyeceğimiz dosyamız

                    try {
                        ftpClient.setType(FTPClient.TYPE_BINARY);
                        ftpClient.connect(server, port);
                        ftpClient.login(username, password);
                        ftpClient.changeDirectory(remotePath); //ftp'mizde yükleyeceğimiz dosyanın yolunnu şu şekilde değiştirebilirsiniz.
                        ftpClient.createDirectory(newDirectory); //bu şekilde yeni klasör oluşturabilirsiniz.
                        ftpClient.changeDirectory(newDirectory); //yeni klasörü oluşturduktan sonra yolunuzu değiştirmeyi unutmayın
                        ftpClient.upload(file);
                        ftpClient.logout();
                    } catch (Exception e) {
                        Log.e("TAG", e.getMessage());
                    }
                    return null;
                }
           }.execute();
        }
    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory,"sudoku_unsolved.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    private void loadImageFromStorage(String path)
    {
        try {
            File f = new File(path, "sudoku_unsolved.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img = (ImageView)findViewById(R.id.image_photo);
            img.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

//    public void printResults(String path)
//    {
//        startActivity(new Intent(getApplicationContext(),PrintActivity.class));
//        tw.setText(path);
//
//    }

    private class DownloadImageTask extends AsyncTask <String, Void, String> {
        protected String doInBackground(String... urls) {
            try{
//                URL obj = new URL(urls[0]);
//                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//                con.setRequestMethod("GET");
//                con.setRequestProperty("User-Agent", "Mozilla/5.0");
//                int responseCode = con.getResponseCode();
//                System.out.println("GET Response Code :: " + responseCode);
//                if (responseCode == HttpURLConnection.HTTP_OK) { // success
//                    BufferedReader in = new BufferedReader(new InputStreamReader(
//                            con.getInputStream()));
//                    String inputLine;
//                    StringBuffer response = new StringBuffer();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    in.close();
//
//                    // print result
//                    return response.toString();
//                } else {
//                    System.out.println("GET request not worked");
//                }


                byte[] postData       = POST_PARAMS.getBytes();
                int    postDataLength = postData.length;
                URL obj = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");


                // For POST only - START
                con.setDoOutput(true);
                con.setInstanceFollowRedirects( false );
                con.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
                OutputStream os = con.getOutputStream();
                os.write(postData);
                os.flush();
                os.close();
                // For POST only - END

                int responseCode = con.getResponseCode();
//                System.out.println("POST Response Code :: " + responseCode);



                if (responseCode == HttpURLConnection.HTTP_OK) { //success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // print result
                    // burada baska bir fonk cagir ve o bastirma islemini yapsin
                    solution=response.toString();
//                    System.out.println(response.toString());
                } else {
                    System.out.println("POST request not worked");
                }

            }
            catch(Exception e){System.out.println("Request not worked");}
            return "bilge";
        }

        protected void onPostExecute(Bitmap result) {

        }
    }
}
