package com.example.toluwase.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EventListener;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    int generatedNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Generate number:
        generatedNumber = generateRandomNo(1,20);
        guessButtonOnClick();

    }

    //Guesser
    public void guessRandomNumber() {
        logger("Generated Number: " + this.generatedNumber);
        if (getUserInput(R.id.input_guess) < this.generatedNumber){
            toastMsg("Higher!");
        }
        else if (getUserInput(R.id.input_guess) > this.generatedNumber){
            toastMsg("Lower!");
        }
        else {
            toastMsg("Perfect!");
            this.generatedNumber = generateRandomNo(1, 20);
        }
    }

    //get user input
    public int getUserInput(int ViewId){
        EditText userInput = (EditText) findViewById(ViewId);
        int value = Integer.parseInt(userInput.getText().toString());
        return value;
    }

    // Method to generate random number
    public int generateRandomNo(int min, int max){
        Random rand = new Random();
        final int randomNumber = rand.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
    public void logger(String message) {
        Log.i("Logger Message", message);
    }

    public void toastMsg(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG ).show();
    }


    protected void guessButtonOnClick() {
        //Click Guess
        final Button guessBtn = (Button) findViewById(R.id.guessButton);
        guessBtn.setOnClickListener( new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v) {
                                              guessRandomNumber();
                                         }

                                     }
        );
    }






}
