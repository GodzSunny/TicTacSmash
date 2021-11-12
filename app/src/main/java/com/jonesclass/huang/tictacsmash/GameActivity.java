package com.jonesclass.huang.tictacsmash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Random rNumber = new Random();
    int rockWins = 0;
    int scissorWins = 0;
    int actions = 9;
    String teamChoice = "Rock";
    String rockScore = "Rock: 0 ";
    String scissorScore = "Scissor: 0";

    ImageButton[][] imageButtons = new ImageButton[3][3];
    int[][] values = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView rock = findViewById(R.id.textView_rock);
        TextView scissor = findViewById(R.id.textView_scissor);
        imageButtons[0][0] = findViewById(R.id.imageButton_00);
        imageButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(0,0);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[0][1] = findViewById(R.id.imageButton_01);
        imageButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(0,1);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[0][2] = findViewById(R.id.imageButton_02);
        imageButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(0,2);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[1][0] = findViewById(R.id.imageButton_10);
        imageButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(1,0);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[1][1] = findViewById(R.id.imageButton_11);
        imageButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(1,1);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[1][2] = findViewById(R.id.imageButton_12);
        imageButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(1,2);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[2][0] = findViewById(R.id.imageButton_20);
        imageButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(2,0);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[2][1] = findViewById(R.id.imageButton_21);
        imageButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(2,1);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });

        imageButtons[2][2] = findViewById(R.id.imageButton_22);
        imageButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageButtons[0][0].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                buttonClicked(2,2);
                rock.setText(rockScore);
                scissor.setText(scissorScore);
            }
        });


    }

    public void buttonClicked(int row, int column) {
        String teamChoiceIntent = getIntent().getStringExtra("Team Choice");
                if (teamChoice.equalsIgnoreCase("Rock")) {
                    imageButtons[row][column].setImageDrawable(getResources().getDrawable(R.drawable.rock));
                    imageButtons[row][column].setClickable(false);
                    values[row][column] = 1;
                    teamChoice = "Scissor";

                } else {
                    imageButtons[row][column].setImageDrawable(getResources().getDrawable(R.drawable.scissors));
                    imageButtons[row][column].setClickable(false);
                    values[row][column] = 4;
                    teamChoice = "Rock";
                }
        System.out.println(row + " " +  column + values[row][column]);
    }






    //Create the AI

    //Check to win




}