package com.droidloft.dicey;

import android.content.pm.ActivityInfo;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String version = "0.2", buildDate = "6-6-2017";

    private ImageView dice1ImageView, dice2ImageView;
    private Button rollButton;
    Vibrator vib;
    boolean isDiceAnimationOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        dice1ImageView = (ImageView)findViewById(R.id.dice1ImageView);
        dice2ImageView = (ImageView)findViewById(R.id.dice2ImageView);
        rollButton = (Button)findViewById(R.id.rollButton);
        vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        final Animation rollAnimation = AnimationUtils.loadAnimation(this, R.anim.rollanim);

        final int[] diceimages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vib.vibrate(100);

                Random r = new Random();
                int die1 = r.nextInt(7-1) + 1;
                int die2 = r.nextInt(7-1) + 1;

                int imgNumber1 = die1 - 1;
                int imgNumber2 = die2 - 1;

                if(isDiceAnimationOn){
                    dice1ImageView.startAnimation(rollAnimation);
                    dice2ImageView.startAnimation(rollAnimation);
                }


                dice1ImageView.setImageResource(diceimages[imgNumber1]);
                dice2ImageView.setImageResource(diceimages[imgNumber2]);


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

        if(item.getItemId() == R.id.dice_animation_on){

            if(item.isChecked()) {
                item.setChecked(false);
                Toast.makeText(MainActivity.this, "Dice Animations Turned Off", Toast.LENGTH_SHORT).show();
            } else {
                item.setChecked(true);
                Toast.makeText(MainActivity.this, "Dice Animations Turned On", Toast.LENGTH_SHORT).show();
            }

            if(isDiceAnimationOn == true) {
                isDiceAnimationOn = false;
            } else {
                isDiceAnimationOn = true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
