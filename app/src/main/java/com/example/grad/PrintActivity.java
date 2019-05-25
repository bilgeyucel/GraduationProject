package com.example.grad;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class PrintActivity extends AppCompatActivity {

    public static final String RECOGNIZED_KEY = "RECOGNIZED_KEY";
    private static String POST_PARAMS = "array=";
    private List<EditText> editTextList = new ArrayList<>();
    private Switch modifySwitch;
    private Button saveButton;
    private Button hintButton;
    private Button solutionButton;
    public String splitrecognized[] = new String[81];
    public String splitimageSolution[]= new String[81];
    public Boolean modifiableStatus = false;
    public TextView solution;
    private PrintViewModel viewModel;
    String recognizedSudokuErrorString="No solution!";
    String str;
    public Boolean successFlag = false;
    public String recognizedFromServerSolution = "henuz yok";
    public String recognized = "henuz yok";
    public String imageSolution = "henuz yok";
    public Boolean isSudoku = true;
    public Boolean isSolution = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        viewModel = ViewModelProviders.of(this).get(PrintViewModel.class);
        solution = findViewById(R.id.printView);
        saveButton = findViewById(R.id.saveButton);
        modifySwitch =findViewById(R.id.switch1);
        hintButton = findViewById(R.id.hintButton);
        solutionButton = findViewById(R.id.solutionButton);



        // HEPSI FINAL OLUCAk
        final EditText editText11 = findViewById(R.id.editText11);
        final EditText editText12 = findViewById(R.id.editText12);
        final EditText editText13 = findViewById(R.id.editText13);
        final EditText editText14 = findViewById(R.id.editText14);
        final EditText editText15 = findViewById(R.id.editText15);
        final EditText editText16 = findViewById(R.id.editText16);
        final EditText editText17 = findViewById(R.id.editText17);
        final EditText editText18 = findViewById(R.id.editText18);
        final EditText editText19 = findViewById(R.id.editText19);

        final EditText editText21 = findViewById(R.id.editText21);
        final EditText editText22 = findViewById(R.id.editText22);
        final EditText editText23 = findViewById(R.id.editText23);
        final EditText editText24 = findViewById(R.id.editText24);
        final EditText editText25 = findViewById(R.id.editText25);
        final EditText editText26 = findViewById(R.id.editText26);
        final EditText editText27 = findViewById(R.id.editText27);
        final EditText editText28 = findViewById(R.id.editText28);
        final EditText editText29 = findViewById(R.id.editText29);

        final EditText editText31 = findViewById(R.id.editText31);
        final EditText editText32 = findViewById(R.id.editText32);
        final EditText editText33 = findViewById(R.id.editText33);
        final EditText editText34 = findViewById(R.id.editText34);
        final EditText editText35 = findViewById(R.id.editText35);
        final EditText editText36 = findViewById(R.id.editText36);
        final EditText editText37 = findViewById(R.id.editText37);
        final EditText editText38 = findViewById(R.id.editText38);
        final EditText editText39 = findViewById(R.id.editText39);

        final EditText editText41 = findViewById(R.id.editText41);
        final EditText editText42 = findViewById(R.id.editText42);
        final EditText editText43 = findViewById(R.id.editText43);
        final EditText editText44 = findViewById(R.id.editText44);
        final EditText editText45 = findViewById(R.id.editText45);
        final EditText editText46 = findViewById(R.id.editText46);
        final EditText editText47 = findViewById(R.id.editText47);
        final EditText editText48 = findViewById(R.id.editText48);
        final EditText editText49 = findViewById(R.id.editText49);

        final EditText editText51 = findViewById(R.id.editText51);
        final EditText editText52 = findViewById(R.id.editText52);
        final EditText editText53 = findViewById(R.id.editText53);
        final EditText editText54 = findViewById(R.id.editText54);
        final EditText editText55 = findViewById(R.id.editText55);
        final EditText editText56 = findViewById(R.id.editText56);
        final EditText editText57 = findViewById(R.id.editText57);
        final EditText editText58 = findViewById(R.id.editText58);
        final EditText editText59 = findViewById(R.id.editText59);

        final EditText editText61 = findViewById(R.id.editText61);
        final EditText editText62 = findViewById(R.id.editText62);
        final EditText editText63 = findViewById(R.id.editText63);
        final EditText editText64 = findViewById(R.id.editText64);
        final EditText editText65 = findViewById(R.id.editText65);
        final EditText editText66 = findViewById(R.id.editText66);
        final EditText editText67 = findViewById(R.id.editText67);
        final EditText editText68 = findViewById(R.id.editText68);
        final EditText editText69 = findViewById(R.id.editText69);

        final EditText editText71 = findViewById(R.id.editText71);
        final EditText editText72 = findViewById(R.id.editText72);
        final EditText editText73 = findViewById(R.id.editText73);
        final EditText editText74 = findViewById(R.id.editText74);
        final EditText editText75 = findViewById(R.id.editText75);
        final EditText editText76 = findViewById(R.id.editText76);
        final EditText editText77 = findViewById(R.id.editText77);
        final EditText editText78 = findViewById(R.id.editText78);
        final EditText editText79 = findViewById(R.id.editText79);

        final EditText editText81 = findViewById(R.id.editText81);
        final EditText editText82 = findViewById(R.id.editText82);
        final EditText editText83 = findViewById(R.id.editText83);
        final EditText editText84 = findViewById(R.id.editText84);
        final EditText editText85 = findViewById(R.id.editText85);
        final EditText editText86 = findViewById(R.id.editText86);
        final EditText editText87 = findViewById(R.id.editText87);
        final EditText editText88 = findViewById(R.id.editText88);
        final EditText editText89 = findViewById(R.id.editText89);

        final EditText editText91 = findViewById(R.id.editText91);
        final EditText editText92 = findViewById(R.id.editText92);
        final EditText editText93 = findViewById(R.id.editText93);
        final EditText editText94 = findViewById(R.id.editText94);
        final EditText editText95 = findViewById(R.id.editText95);
        final EditText editText96 = findViewById(R.id.editText96);
        final EditText editText97 = findViewById(R.id.editText97); // hint icin
        final EditText editText98 = findViewById(R.id.editText98);
        final EditText editText99 = findViewById(R.id.editText99);

        editTextList.add(editText11);
        editTextList.add(editText12);
        editTextList.add(editText13);
        editTextList.add(editText14);
        editTextList.add(editText15);
        editTextList.add(editText16);
        editTextList.add(editText17);
        editTextList.add(editText18);
        editTextList.add(editText19);

        editTextList.add(editText21);
        editTextList.add(editText22);
        editTextList.add(editText23);
        editTextList.add(editText24);
        editTextList.add(editText25);
        editTextList.add(editText26);
        editTextList.add(editText27);
        editTextList.add(editText28);
        editTextList.add(editText29);

        editTextList.add(editText31);
        editTextList.add(editText32);
        editTextList.add(editText33);
        editTextList.add(editText34);
        editTextList.add(editText35);
        editTextList.add(editText36);
        editTextList.add(editText37);
        editTextList.add(editText38);
        editTextList.add(editText39);

        editTextList.add(editText41);
        editTextList.add(editText42);
        editTextList.add(editText43);
        editTextList.add(editText44);
        editTextList.add(editText45);
        editTextList.add(editText46);
        editTextList.add(editText47);
        editTextList.add(editText48);
        editTextList.add(editText49);

        editTextList.add(editText51);
        editTextList.add(editText52);
        editTextList.add(editText53);
        editTextList.add(editText54);
        editTextList.add(editText55);
        editTextList.add(editText56);
        editTextList.add(editText57);
        editTextList.add(editText58);
        editTextList.add(editText59);

        editTextList.add(editText61);
        editTextList.add(editText62);
        editTextList.add(editText63);
        editTextList.add(editText64);
        editTextList.add(editText65);
        editTextList.add(editText66);
        editTextList.add(editText67);
        editTextList.add(editText68);
        editTextList.add(editText69);

        editTextList.add(editText71);
        editTextList.add(editText72);
        editTextList.add(editText73);
        editTextList.add(editText74);
        editTextList.add(editText75);
        editTextList.add(editText76);
        editTextList.add(editText77);
        editTextList.add(editText78);
        editTextList.add(editText79);

        editTextList.add(editText81);
        editTextList.add(editText82);
        editTextList.add(editText83);
        editTextList.add(editText84);
        editTextList.add(editText85);
        editTextList.add(editText86);
        editTextList.add(editText87);
        editTextList.add(editText88);
        editTextList.add(editText89);

        editTextList.add(editText91);
        editTextList.add(editText92);
        editTextList.add(editText93);
        editTextList.add(editText94);
        editTextList.add(editText95);
        editTextList.add(editText96);
        editTextList.add(editText97);
        editTextList.add(editText98);
        editTextList.add(editText99);

        editText11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText11.getText().toString().equals(""))
                {
                    splitrecognized[0] = "0";
                }
                else {
                    splitrecognized[0] = editText11.getText().toString();
                }
            }
        });
        editText12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText12.getText().toString().equals(""))
                {
                    splitrecognized[1] = "0";
                }
                else {
                    splitrecognized[1] = editText12.getText().toString();}
            }
        });
        editText13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText13.getText().toString().equals(""))
                {
                    splitrecognized[2] = "0";
                }
                else {
                    splitrecognized[2] = editText13.getText().toString();}
            }
        });
        editText14.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText14.getText().toString().equals(""))
                {
                    splitrecognized[3] = "0";
                }
                else {
                    splitrecognized[3] = editText14.getText().toString();}
            }
        });
        editText15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText15.getText().toString().equals(""))
                {
                    splitrecognized[4] = "0";
                }
                else {
                    splitrecognized[4] = editText15.getText().toString();}
            }
        });
        editText16.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText16.getText().toString().equals(""))
                {
                    splitrecognized[5] = "0";
                }
                else {
                    splitrecognized[5] = editText16.getText().toString();}
            }
        });
        editText17.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText17.getText().toString().equals(""))
                {
                    splitrecognized[6] = "0";
                }
                else {
                    splitrecognized[6] = editText17.getText().toString();}
            }
        });
        editText18.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText18.getText().toString().equals(""))
                {
                    splitrecognized[7] = "0";
                }
                else {
                    splitrecognized[7] = editText18.getText().toString();}
            }
        });
        editText19.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText19.getText().toString().equals(""))
                {
                    splitrecognized[8] = "0";
                }
                else {
                    splitrecognized[8] = editText19.getText().toString();}
            }
        });
        editText21.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText21.getText().toString().equals(""))
                {
                    splitrecognized[9] = "0";
                }
                else {
                    splitrecognized[9] = editText21.getText().toString();}
            }
        });
        editText22.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText22.getText().toString().equals(""))
                {
                    splitrecognized[10] = "0";
                }
                else {
                    splitrecognized[10] = editText22.getText().toString();}
            }
        });
        editText23.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText23.getText().toString().equals(""))
                {
                    splitrecognized[11] = "0";
                }
                else {
                    splitrecognized[11] = editText23.getText().toString();}
            }
        });
        editText24.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText24.getText().toString().equals(""))
                {
                    splitrecognized[12] = "0";
                }
                else {
                    splitrecognized[12] = editText24.getText().toString();}
            }
        });
        editText25.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText25.getText().toString().equals(""))
                {
                    splitrecognized[13] = "0";
                }
                else {
                    splitrecognized[13] = editText25.getText().toString();}
            }
        });
        editText26.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText26.getText().toString().equals(""))
                {
                    splitrecognized[14] = "0";
                }
                else {
                    splitrecognized[14] = editText26.getText().toString();}
            }
        });
        editText27.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText27.getText().toString().equals(""))
                {
                    splitrecognized[15] = "0";
                }
                else {
                    splitrecognized[15] = editText27.getText().toString();}
            }
        });
        editText28.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText28.getText().toString().equals(""))
                {
                    splitrecognized[16] = "0";
                }
                else {
                    splitrecognized[16] = editText28.getText().toString();}
            }
        });
        editText29.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText29.getText().toString().equals(""))
                {
                    splitrecognized[17] = "0";
                }
                else {
                    splitrecognized[17] = editText29.getText().toString();}
            }
        });
        editText31.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText31.getText().toString().equals(""))
                {
                    splitrecognized[18] = "0";
                }
                else {
                    splitrecognized[18] = editText31.getText().toString();}
            }
        });
        editText32.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText32.getText().toString().equals(""))
                {
                    splitrecognized[19] = "0";
                }
                else {
                    splitrecognized[19] = editText32.getText().toString();}
            }
        });
        editText33.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText33.getText().toString().equals(""))
                {
                    splitrecognized[20] = "0";
                }
                else {
                    splitrecognized[20] = editText33.getText().toString();}
            }
        });
        editText34.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText34.getText().toString().equals(""))
                {
                    splitrecognized[21] = "0";
                }
                else {
                    splitrecognized[21] = editText34.getText().toString();}
            }
        });
        editText35.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText35.getText().toString().equals(""))
                {
                    splitrecognized[22] = "0";
                }
                else {
                    splitrecognized[22] = editText35.getText().toString();}
            }
        });
        editText36.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText36.getText().toString().equals(""))
                {
                    splitrecognized[23] = "0";
                }
                else {
                    splitrecognized[23] = editText36.getText().toString();}
            }
        });
        editText37.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText37.getText().toString().equals(""))
                {
                    splitrecognized[24] = "0";
                }
                else {
                    splitrecognized[24] = editText37.getText().toString();}
            }
        });
        editText38.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText38.getText().toString().equals(""))
                {
                    splitrecognized[25] = "0";
                }
                else {
                    splitrecognized[25] = editText38.getText().toString();}
            }
        });
        editText39.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText39.getText().toString().equals(""))
                {
                    splitrecognized[26] = "0";
                }
                else {
                    splitrecognized[26] = editText39.getText().toString();}
            }
        });
        editText41.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText41.getText().toString().equals(""))
                {
                    splitrecognized[27] = "0";
                }
                else {
                    splitrecognized[27] = editText41.getText().toString();}
            }
        });
        editText42.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText42.getText().toString().equals(""))
                {
                    splitrecognized[28] = "0";
                }
                else {
                    splitrecognized[28] = editText42.getText().toString();}
            }
        });
        editText43.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText43.getText().toString().equals(""))
                {
                    splitrecognized[29] = "0";
                }
                else {
                    splitrecognized[29] = editText43.getText().toString();}
            }
        });
        editText44.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText44.getText().toString().equals(""))
                {
                    splitrecognized[30] = "0";
                }
                else {
                    splitrecognized[30] = editText44.getText().toString();}
            }
        });
        editText45.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText45.getText().toString().equals(""))
                {
                    splitrecognized[31] = "0";
                }
                else {
                    splitrecognized[31] = editText45.getText().toString();}
            }
        });
        editText46.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText46.getText().toString().equals(""))
                {
                    splitrecognized[32] = "0";
                }
                else {
                    splitrecognized[32] = editText46.getText().toString();}
            }
        });
        editText47.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText47.getText().toString().equals(""))
                {
                    splitrecognized[33] = "0";
                }
                else {
                    splitrecognized[33] = editText47.getText().toString();}
            }
        });
        editText48.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText48.getText().toString().equals(""))
                {
                    splitrecognized[34] = "0";
                }
                else {
                    splitrecognized[34] = editText48.getText().toString();}
            }
        });
        editText49.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText49.getText().toString().equals(""))
                {
                    splitrecognized[35] = "0";
                }
                else {
                    splitrecognized[35] = editText49.getText().toString();}
            }
        });
        editText51.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText51.getText().toString().equals(""))
                {
                    splitrecognized[36] = "0";
                }
                else {
                    splitrecognized[36] = editText51.getText().toString();}
            }
        });
        editText52.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText52.getText().toString().equals(""))
                {
                    splitrecognized[37] = "0";
                }
                else {
                    splitrecognized[37] = editText52.getText().toString();}
            }
        });
        editText53.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText53.getText().toString().equals(""))
                {
                    splitrecognized[38] = "0";
                }
                else {
                    splitrecognized[38] = editText53.getText().toString();}
            }
        });
        editText54.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText54.getText().toString().equals(""))
                {
                    splitrecognized[39] = "0";
                }
                else {
                    splitrecognized[39] = editText54.getText().toString();}
            }
        });
        editText55.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText55.getText().toString().equals(""))
                {
                    splitrecognized[40] = "0";
                }
                else {
                    splitrecognized[40] = editText55.getText().toString();}
            }
        });
        editText56.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText56.getText().toString().equals(""))
                {
                    splitrecognized[41] = "0";
                }
                else {
                    splitrecognized[41] = editText56.getText().toString();}
            }
        });
        editText57.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText57.getText().toString().equals(""))
                {
                    splitrecognized[42] = "0";
                }
                else {
                    splitrecognized[42] = editText57.getText().toString();}
            }
        });
        editText58.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText58.getText().toString().equals(""))
                {
                    splitrecognized[43] = "0";
                }
                else {
                    splitrecognized[43] = editText58.getText().toString();}
            }
        });
        editText59.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText59.getText().toString().equals(""))
                {
                    splitrecognized[44] = "0";
                }
                else {
                    splitrecognized[44] = editText59.getText().toString();}
            }
        });
        editText61.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText61.getText().toString().equals(""))
                {
                    splitrecognized[45] = "0";
                }
                else {
                    splitrecognized[45] = editText61.getText().toString();}
            }
        });
        editText62.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText62.getText().toString().equals(""))
                {
                    splitrecognized[46] = "0";
                }
                else {
                    splitrecognized[46] = editText62.getText().toString();}
            }
        });
        editText63.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText63.getText().toString().equals(""))
                {
                    splitrecognized[47] = "0";
                }
                else {
                    splitrecognized[47] = editText63.getText().toString();}
            }
        });
        editText64.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText64.getText().toString().equals(""))
                {
                    splitrecognized[48] = "0";
                }
                else {
                    splitrecognized[48] = editText64.getText().toString();}
            }
        });
        editText65.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText65.getText().toString().equals(""))
                {
                    splitrecognized[49] = "0";
                }
                else {
                    splitrecognized[49] = editText65.getText().toString();}
            }
        });
        editText66.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText66.getText().toString().equals(""))
                {
                    splitrecognized[50] = "0";
                }
                else {
                    splitrecognized[50] = editText66.getText().toString();}
            }
        });
        editText67.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText67.getText().toString().equals(""))
                {
                    splitrecognized[51] = "0";
                }
                else {
                    splitrecognized[51] = editText67.getText().toString();}
            }
        });
        editText68.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText68.getText().toString().equals(""))
                {
                    splitrecognized[52] = "0";
                }
                else {
                    splitrecognized[52] = editText68.getText().toString();}
            }
        });
        editText69.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText69.getText().toString().equals(""))
                {
                    splitrecognized[53] = "0";
                }
                else {
                    splitrecognized[53] = editText69.getText().toString();}
            }
        });
        editText71.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText71.getText().toString().equals(""))
                {
                    splitrecognized[54] = "0";
                }
                else {
                    splitrecognized[54] = editText71.getText().toString();}
            }
        });
        editText72.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText72.getText().toString().equals(""))
                {
                    splitrecognized[55] = "0";
                }
                else {
                    splitrecognized[55] = editText72.getText().toString();}
            }
        });
        editText73.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText73.getText().toString().equals(""))
                {
                    splitrecognized[56] = "0";
                }
                else {
                    splitrecognized[56] = editText73.getText().toString();}
            }
        });
        editText74.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText74.getText().toString().equals(""))
                {
                    splitrecognized[57] = "0";
                }
                else {
                    splitrecognized[57] = editText74.getText().toString();}
            }
        });
        editText75.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText75.getText().toString().equals(""))
                {
                    splitrecognized[58] = "0";
                }
                else {
                    splitrecognized[58] = editText75.getText().toString();}
            }
        });
        editText76.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText76.getText().toString().equals(""))
                {
                    splitrecognized[59] = "0";
                }
                else {
                    splitrecognized[59] = editText76.getText().toString();}
            }
        });
        editText77.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText77.getText().toString().equals(""))
                {
                    splitrecognized[60] = "0";
                }
                else {
                    splitrecognized[60] = editText77.getText().toString();}
            }
        });
        editText78.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText78.getText().toString().equals(""))
                {
                    splitrecognized[61] = "0";
                }
                else {
                    splitrecognized[61] = editText78.getText().toString();}
            }
        });
        editText79.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText79.getText().toString().equals(""))
                {
                    splitrecognized[62] = "0";
                }
                else {
                    splitrecognized[62] = editText79.getText().toString();}
            }
        });
        editText81.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText81.getText().toString().equals(""))
                {
                    splitrecognized[63] = "0";
                }
                else {
                    splitrecognized[63] = editText81.getText().toString();}
            }
        });
        editText82.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText82.getText().toString().equals(""))
                {
                    splitrecognized[64] = "0";
                }
                else {
                    splitrecognized[64] = editText82.getText().toString();}
            }
        });
        editText83.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText83.getText().toString().equals(""))
                {
                    splitrecognized[65] = "0";
                }
                else {
                    splitrecognized[65] = editText83.getText().toString();}
            }
        });
        editText84.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText84.getText().toString().equals(""))
                {
                    splitrecognized[66] = "0";
                }
                else {
                    splitrecognized[66] = editText84.getText().toString();}
            }
        });
        editText85.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText85.getText().toString().equals(""))
                {
                    splitrecognized[67] = "0";
                }
                else {
                    splitrecognized[67] = editText85.getText().toString();}
            }
        });
        editText86.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText86.getText().toString().equals(""))
                {
                    splitrecognized[68] = "0";
                }
                else {
                    splitrecognized[68] = editText86.getText().toString();}
            }
        });
        editText87.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText87.getText().toString().equals(""))
                {
                    splitrecognized[69] = "0";
                }
                else {
                    splitrecognized[69] = editText87.getText().toString();}
            }
        });
        editText88.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText88.getText().toString().equals(""))
                {
                    splitrecognized[70] = "0";
                }
                else {
                    splitrecognized[70] = editText88.getText().toString();}
            }
        });
        editText89.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText89.getText().toString().equals(""))
                {
                    splitrecognized[71] = "0";
                }
                else {
                    splitrecognized[71] = editText89.getText().toString();}
            }
        });
        editText91.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText91.getText().toString().equals(""))
                {
                    splitrecognized[72] = "0";
                }
                else {
                    splitrecognized[72] = editText91.getText().toString();}
            }
        });
        editText92.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText92.getText().toString().equals(""))
                {
                    splitrecognized[73] = "0";
                }
                else {
                    splitrecognized[73] = editText92.getText().toString();}
            }
        });
        editText93.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText93.getText().toString().equals(""))
                {
                    splitrecognized[74] = "0";
                }
                else {
                    splitrecognized[74] = editText93.getText().toString();}
            }
        });
        editText94.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText94.getText().toString().equals(""))
                {
                    splitrecognized[75] = "0";
                }
                else {
                    splitrecognized[75] = editText94.getText().toString();}
            }
        });
        editText95.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText95.getText().toString().equals(""))
                {
                    splitrecognized[76] = "0";
                }
                else {
                    splitrecognized[76] = editText95.getText().toString();}
            }
        });
        editText96.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText96.getText().toString().equals(""))
                {
                    splitrecognized[77] = "0";
                }
                else {
                    splitrecognized[77] = editText96.getText().toString();}
            }
        });
        editText97.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText97.getText().toString().equals(""))
                {
                    splitrecognized[78] = "0";
                }
                else {
                    splitrecognized[78] = editText97.getText().toString();}
            }
        });
        editText98.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText98.getText().toString().equals(""))
                {
                    splitrecognized[79] = "0";
                }
                else {
                    splitrecognized[79] = editText98.getText().toString();
                }

            }
        });
        editText99.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText99.getText().toString().equals(""))
                {
                    splitrecognized[80] = "0";
                }
                else {
                    splitrecognized[80] = editText99.getText().toString();
                }
            }
        });

        //SET ALL EDITTEXT UNMODIFIABLE

        for(EditText e: editTextList){
            e.setEnabled(modifiableStatus);
            e.setText("");
        }



        if (savedInstanceState != null) {
            viewModel.readFromBundle(savedInstanceState);
        } else {
            str = getIntent().getStringExtra(MainActivity.KEY);
//            viewModel.setSolution(getIntent().getStringExtra(MainActivity.KEY));

        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newString = Arrays.toString(splitrecognized);

                solution.setText("");
                POST_PARAMS = "array=" + newString;
                isSolution=false;
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
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive

                    if(isSudoku==false){
                        solution.setText("Since there is no recognized sudoku, you cannot take any hints!");
                    }
                    else if (isSolution==false){
                        solution.setText("No hints for the sudoku, please check the board again");
                    }
                    else{
                        boolean found = false;
                        while(found==false){
                            int randomNum = randInt(0,80);
//                    solution.setText(splitimageSolution[randomNum]+" " + randomNum);
                            EditText hintEditText = editTextList.get(randomNum);
                            if (splitrecognized[randomNum]=="0"){
                                hintEditText.setTextColor(Color.RED);

                                hintEditText.setText(splitimageSolution[randomNum]);
                                found = true;
                            }

                        }

                    }

                }
                catch(Exception e)
                {

//                    String newString = Arrays.toString(splitrecognized);
                    solution.setText("Since there is no recognized sudoku, you cannot take any hints!");
                }

            }
        });
        solutionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(isSudoku==false){
                        solution.setText("No solution, sudoku is not found!");

                    }
                    else if (isSolution==false){
                        solution.setText("No solution for the sudoku, please check the board again");
                    }
                    else{
                        int i = 0;
                        for(EditText e: editTextList) { // isSudoku false if'inin icine alirsan patlayabilir boyle kalsin birak
                            e.setText(splitimageSolution[i]);
                            i++;
                        }
                        solution.setText("SOLUTION OF THE SUDOKU");
                    }
                }
                catch(Exception e)
                {

//                    String newString = Arrays.toString(splitimageSolution);
//                    solution.setText("THERE IS NO SOLUTION :(");
                    solution.setText(recognizedSudokuErrorString);

                }
            }
        });

//        String str = getIntent().getStringExtra(MainActivity.KEY);


        try{
            isSudoku =true;
            int[] arr = new int[81];
            int[] numCorrect = new int [10];
            for(int i = 0; i<10; i++){
                numCorrect[i]=0;
            }
            recognized = str.substring(1, 242);
            splitrecognized = recognized.split(", ", 0);
            for(int b = 0; b<81; b++){
                Integer index = Integer.valueOf(splitrecognized[b]);
                numCorrect[index]++;

                    if ((numCorrect[index] > 11 && index!=0) || numCorrect[0]>75) {
                        imageSolution = "";
                        splitrecognized = new String[81];
                        isSudoku = false;
                        break;

                    }


            }
            try{
                if (isSudoku)
                {
                    imageSolution = str.substring(244, 485);
                    splitimageSolution = imageSolution.split(", ", 0);
                }
            }
            catch(Exception e){
                if (isSudoku){solution.setText("Please correct the numbers, no solution found for these numbers.");}
            }

//            editText11.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    System.out.println("clicked calisti");
//                }
//            });

            try{
                if (isSudoku){int j = 0;
                    for(EditText e: editTextList) {
                        if(splitrecognized[j].equals("0")){
                            e.setText("");
                        }
                        else{
                            e.setText(splitrecognized[j]);
                        }
                        j++;

                    }
//                    solution.setText("");
                }
                    else if(isSudoku==false){
                    solution.setText("Oops couldn't be recognized!");
                }

            }catch (Exception e){
                solution.setText("Oops couldn't be recognized!");
            }

        }catch (Exception e1){
            solution.setText("Something went wrong! Please go back and take the photo again");

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
        @Override
        protected String doInBackground(String... urls) {

            try {

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
                System.out.println("GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
//                            System.out.println(i);
                    }
                    String temp = response.toString();
//                    imageSolution="";
//                    splitimageSolution=new String[81];
                    try{
                        imageSolution = temp.substring(1, 242);
                        splitimageSolution = imageSolution.split(", ", 0);
                        isSolution = true;
                    }catch (Exception e){
                        isSolution = false;
//                        recognizedSudokuErrorString = "No solution is found for this sudoku";
                    }


                    in.close();
                    successFlag = true;
                    isSudoku=true;
                    recognizedSudokuErrorString = "Solution is saved";
                    return imageSolution;
                } else {
                    System.out.println("GET request not worked");
                    recognizedSudokuErrorString = "No solution is found for this sudoku";
                }
            }
            catch(Exception e){
                System.out.println("Request not worked");
                successFlag = false;
                recognizedSudokuErrorString = "This sudoku cannot be solved, please check the numbers";

//                solution.setText("Since there is no recognized sudoku, you cannot take any hints!");
            }
            return "recognition is not successful";
        }

        @Override
        protected void onPostExecute(String r) {
            if (isSolution){

                solution.setText("New numbers are saved!");
            }
            else if (isSolution== false){

                solution.setText("No solution is found for this sudoku, please check it again");
            }

        }
    }

    public static int randInt(int min, int max) {

        Random random = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
