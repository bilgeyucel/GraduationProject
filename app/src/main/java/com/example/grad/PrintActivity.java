package com.example.grad;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class PrintActivity extends AppCompatActivity {

    public static final String RECOGNIZED_KEY = "RECOGNIZED_KEY";
    private List<EditText> editTextList = new ArrayList<>();
    private Switch modifySwitch;
    private Button saveButton;
    private Button hintButton;
    private Button solutionButton;
    public String splittemp[];
    public Boolean modifiableStatus = true;
    private PrintViewModel viewModel;
    String str;
    public Boolean successFlag = false;
    public String recognizedFromServerSolution = "henuz yok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        viewModel = ViewModelProviders.of(this).get(PrintViewModel.class);
        saveButton = findViewById(R.id.saveButton);
        modifySwitch =findViewById(R.id.switch1);
        hintButton = findViewById(R.id.hintButton);
        solutionButton = findViewById(R.id.solutionButton);



        // HEPSI FINAL OLUCAk
        final EditText textView11 = findViewById(R.id.textView11);
        final EditText textView12 = findViewById(R.id.textView12);
        EditText textView13 = findViewById(R.id.textView13);

        TextView textView14 = findViewById(R.id.textView14);
        final TextView textView97 = findViewById(R.id.textView97); // hint icin
        TextView textView98 = findViewById(R.id.textView98);
        TextView textView99 = findViewById(R.id.textView99);


        if (savedInstanceState != null) {
            viewModel.readFromBundle(savedInstanceState);
        } else {
            str = getIntent().getStringExtra(MainActivity.KEY);
//            viewModel.setSolution(getIntent().getStringExtra(MainActivity.KEY));

        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("button calisti");
//                Intent intent = new Intent(PrintActivity.this, MainActivity.class);
////                Intent intent = new Intent(PrintActivity.this,PrintActivity.class);
////                intent.putExtra(MainActivity.KEY, splittemp.toString());
//                intent.putExtra(MainActivity.KEY, "bayagi bununla alakali");
//                intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP);
//
//                finish();
//                startActivity(intent);

                new DownloadImageTask().execute("http://134.209.226.2:5000/api/recognizedSudoku");



            }
        });
        modifySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for(EditText e: editTextList){
                    e.setEnabled(!modifiableStatus);
                }
                modifiableStatus = !modifiableStatus;

            }
        });
        hintButton.setOnClickListener(new View.OnClickListener() {
            //giver random hint
            @Override
            public void onClick(View v) {
                try{
                    textView97.setText(splittemp[78]);
                }
                catch(Exception e)
                {

                }

            }
        });
        solutionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int i = 0;
                    for(EditText e: editTextList) {
                        e.setText(splittemp[i+1]);
                        i++;
                    }
                }
                catch(Exception e)
                {

                }
            }
        });

//        String str = getIntent().getStringExtra(MainActivity.KEY);


        try{
            int[] arr = new int[81];
            str = str.substring(1, 242);
//                        str.split(",", 0);
//                        str = split.toString();
        splittemp = str.split(", ", 0);
        int i = 0;
        for (String s : splittemp) {
            int a = Integer.valueOf(s);
            arr[i] = a;
            i++;
        }
        TextView solution = findViewById(R.id.printView);
        solution.setText(getIntent().getStringExtra(MainActivity.KEY));


        textView11.setText(splittemp[0]);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked calisti");
            }
        });
        textView11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                System.out.println("listener calisti");
            }

            @Override
            public void afterTextChanged(Editable s) {

                System.out.println("afterchanged calisti");
                splittemp[0] = textView11.getText().toString();
            }
        });

        textView12.setText(splittemp[1]);
        textView12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("afterchanged for 12 calisti");
                splittemp[1] = textView12.getText().toString();
            }
        });

        textView13.setText(splittemp[2]);
        textView14.setText(splittemp[3]);

        textView98.setText(splittemp[79]);

        textView99.setText(splittemp[80]);
            editTextList.add(textView11);
            editTextList.add(textView12);
            editTextList.add(textView13);
    }catch (Exception e1){
            TextView solution = findViewById(R.id.printView);
            solution.setText(getIntent().getStringExtra(MainActivity.KEY));

        }

    }
    private String TAG = "printActivity";
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

    private class DownloadImageTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {

            try {
                URL obj = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine, str = "";
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
//                            System.out.println(i);
                    }
                    recognizedFromServerSolution = response.toString();

//                        solution= splittemp[2];
//                        solution = splittemp.toString();
//                        System.out.println(splittemp);
                    in.close();

                    // print result
                    successFlag = true;
                    return recognizedFromServerSolution;
                } else {
                    System.out.println("GET request not worked");
                }
            }
            catch(Exception e){
                System.out.println("Request not worked");

            }
            return "recognition is not successful";
        }
    }
}
