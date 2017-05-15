package com.example.android.beatmeifyoucan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.music);
    }

    /** If the button is clicked, music starts
     *
     * @param view
     */

    public void playMusic(View view) {
        if (mySound != null && !mySound.isPlaying()) {
            mySound.start();
        }
    }

    /** If the button is clicked, music stops*/

   // protected void onPause() {
   //     super.onPause();
   //     if (mySound != null && mySound.isPlaying()) {
   //         mySound.pause();
   //     }
//    }

    public void openGame2(View view) {
        Intent i = new Intent(this, game2Activity.class);
        startActivity(i);
    }

    public void openGame1(View view) {
        Intent i = new Intent(this, game1Activity.class);
        startActivity(i);
    }
}
