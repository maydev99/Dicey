package com.droidloft.dicey;

import android.content.pm.ActivityInfo;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String version = "0.1", buildDate = "5-26-2017";

    private ImageView dice1ImageView, dice2ImageView;
    private Button rollButton;
    Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dice1ImageView = (ImageView)findViewById(R.id.dice1ImageView);
        dice2ImageView = (ImageView)findViewById(R.id.dice2ImageView);
        rollButton = (Button)findViewById(R.id.rollButton);
        vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vib.vibrate(100);

                Random r = new Random();
                int die1 = r.nextInt(7-1) + 1;
                int die2 = r.nextInt(7-1) + 1;


                if(die1 == 1){
                    dice1ImageView.setImageResource(R.drawable.dice1);
                } else if(die1 == 2){
                    dice1ImageView.setImageResource(R.drawable.dice2);
                } else if(die1 == 3){
                    dice1ImageView.setImageResource(R.drawable.dice3);
                } else if(die1 == 4) {
                    dice1ImageView.setImageResource(R.drawable.dice4);
                } else if(die1 == 5) {
                    dice1ImageView.setImageResource(R.drawable.dice5);
                } else {
                    dice1ImageView.setImageResource(R.drawable.dice6);
                }

                if(die2 == 1){
                    dice2ImageView.setImageResource(R.drawable.dice1);
                } else if(die2 == 2){
                    dice2ImageView.setImageResource(R.drawable.dice2);
                } else if(die2 == 3){
                    dice2ImageView.setImageResource(R.drawable.dice3);
                } else if(die2 == 4) {
                    dice2ImageView.setImageResource(R.drawable.dice4);
                } else if(die2 == 5) {
                    dice2ImageView.setImageResource(R.drawable.dice5);
                } else {
                    dice2ImageView.setImageResource(R.drawable.dice6);
                }




            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.about) {
            AlertDialog.Builder aboutAlert = new AlertDialog.Builder(this);
            aboutAlert.setTitle("Dicey v" + version);
            aboutAlert.setMessage("Build Date: " + buildDate + "\n" + "by Michael May" + "\n" + "DroidLoft");
            aboutAlert.setIcon(R.drawable.dice3);
            aboutAlert.setCancelable(true);
            aboutAlert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
