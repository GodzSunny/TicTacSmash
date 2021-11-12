package com.jonesclass.huang.tictacsmash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    final String TAG = "Main Activity Tag";

    Button startButton;
    Button selectButton;
    String teamChoice = "";
    Boolean TeamChoice= true;
    Boolean twoPlayers = false;
    AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton TWO_PLAYER_RADIO_BUTTON = findViewById(R.id.radioButton_2players);

        RadioGroup playersRadioGroup = findViewById(R.id.radioGroup_players);
        playersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton_2players){
                    startButton.setVisibility(View.VISIBLE);
                    selectButton.setVisibility(View.GONE);
                    twoPlayers = true;
                } else {
                    startButton.setVisibility(View.GONE);
                    selectButton.setVisibility(View.VISIBLE);
                }
            }
        });

        startButton = findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(getApplicationContext(), GameActivity.class);
                if(!twoPlayers){
                    TeamChoice = false;
                    gameIntent.putExtra("Two Players",false);
                    if(teamChoice.equalsIgnoreCase("Rock")){
                        gameIntent.putExtra("Team Choice", "Rock");
                    } else {
                        gameIntent.putExtra("Team Choice", "Scissor");
                    }
                    Log.d(TAG, "onClick: 1 players selected and player selected: " + (String.valueOf(teamChoice)));

                } else {
                    twoPlayers = true;
                    TeamChoice = true;
                    gameIntent.putExtra("Two Players",true);
                    gameIntent.putExtra("Team Choice","Rock");
                    Log.d(TAG, "onClick: Single Player Selected");
                }
                startActivity(gameIntent);
            }
        });

        selectButton = findViewById(R.id.button_selectTeam);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTeamDialog();
            }
        });



    }
    public void selectTeamDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final String[] TEAM_CHOICES = {"Rock", "Scissor"};
        dialogBuilder.setTitle("Choose your team");
        dialogBuilder.setSingleChoiceItems(TEAM_CHOICES, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                teamChoice = TEAM_CHOICES[which];
                if(teamChoice.equals("Rock")) {
                    Toast.makeText(MainActivity.this," ROCK! ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, " SCISSOR! ", Toast.LENGTH_SHORT).show();
                }
                startButton.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"No Team Selected", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

}