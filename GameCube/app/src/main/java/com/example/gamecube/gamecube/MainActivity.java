package com.example.gamecube.gamecube;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> images = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add(0, R.drawable.dado);
        images.add(1, R.drawable.dado1);
        images.add(2, R.drawable.dado2);
        images.add(3, R.drawable.dado3);
        images.add(4, R.drawable.dado4);
        images.add(5, R.drawable.dado5);
        images.add(6, R.drawable.dado6);
    }

    public void play(View view) {
        Random random = new Random();

        int player = random.nextInt(5);
        int computer = random.nextInt(5);

        if (player == computer) {
            Toast.makeText(this, "Draw, Play again!", Toast.LENGTH_SHORT);
        } else {
            for (int i = 1; i < images.size(); i++) {
                if (i == player) {
                    ImageView p = (ImageView) findViewById(R.id.image_player);
                    p.setImageResource(images.get(i));
                }

                if (i == computer) {
                    ImageView c = (ImageView) findViewById(R.id.image_computer);
                    c.setImageResource(images.get(i));
                }
            }

            if (player > computer) {
                Toast.makeText(this, "Player won!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Computer won!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
