package com.example.grad;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class CorrectActivity extends AppCompatActivity {
    private CorrectViewModel viewModel;
    private Button sendButton;
    private TextView textView;
    private String str = "hebele";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);
        viewModel = ViewModelProviders.of(this).get(CorrectViewModel.class);
        sendButton = findViewById(R.id.send_button);
        textView = findViewById(R.id.textView);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("gereksiz bir buton aslinda");
            }
        });
        textView.setText(str);


//        if(savedInstanceState != null){
//            viewModel.readFromBundle(savedInstanceState);
//        }else{
//            str = getIntent().getStringExtra(MainActivity.RECOGNIZED_KEY);
////            viewModel.setSolution(getIntent().getStringExtra(MainActivity.KEY));
//            textView.setText(str);
//        }



    }


}
