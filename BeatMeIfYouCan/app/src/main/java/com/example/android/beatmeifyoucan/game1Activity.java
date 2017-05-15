package com.example.android.beatmeifyoucan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class game1Activity extends AppCompatActivity {

    private static final String STATE_SCORETEAM1 = "player1";
    private static final String STATE_SCORETEAM2 = "player2";
    int player1 = 0;
    int player2 = 0;

    // Hide Keyboard after clicking
    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
    }

    //save score of player 1 and player 2
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_SCORETEAM1, player1);
        savedInstanceState.putInt(STATE_SCORETEAM2, player2);

    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        player1 = savedInstanceState.getInt(STATE_SCORETEAM1);
        player2 = savedInstanceState.getInt(STATE_SCORETEAM2);

        display(player1);
        display2(player2);

    }

    /**
     * This method is called when the button button increasing points is clicked.
     */

    public void increment1(View view) {
        player1 = player1 + 1;
        Toast.makeText(getApplicationContext(), "1 point added", Toast.LENGTH_SHORT).show();
        display(player1);
    }

    public void increment2(View view) {
        player1 = player1 + 2;
        Toast.makeText(getApplicationContext(), "2 points added", Toast.LENGTH_SHORT).show();
        display(player1);
    }

    public void increment3(View view) {
        player1 = player1 + 3;
        Toast.makeText(getApplicationContext(), "3 points added", Toast.LENGTH_SHORT).show();
        display(player1);
    }

    public void increment4(View view) {
        player2 = player2 + 1;
        Toast.makeText(getApplicationContext(), "1 point added", Toast.LENGTH_SHORT).show();
        display2(player2);
    }

    public void increment5(View view) {
        player2 = player2 + 2;
        Toast.makeText(getApplicationContext(), "2 points added", Toast.LENGTH_SHORT).show();
        display2(player2);
    }

    public void increment6(View view) {
        player2 = player2 + 3;
        Toast.makeText(getApplicationContext(), "3 points added", Toast.LENGTH_SHORT).show();
        display2(player2);
    }

    // This method is called when decrement button is clicked.

    public void decrement1(View view) {
        if (player1 == 0) {
            //show error
            Toast.makeText(this, "It is not possible to have less than 0 points", Toast.LENGTH_SHORT).show();
            return;
        }
        player1 = player1 - 1;
        Toast.makeText(getApplicationContext(), "-1 point", Toast.LENGTH_SHORT).show();
        display(player1);
    }

    public void decrement2(View view) {
        if (player2 == 0) {
            //show error
            Toast.makeText(this, "It is not possible to have less than 0 points", Toast.LENGTH_SHORT).show();
            return;
        }
        player2 = player2 - 1;
        Toast.makeText(getApplicationContext(), "-1 point", Toast.LENGTH_SHORT).show();
        display2(player2);
    }

    //This method is called when the submit results button is clicked.

    public void submitResults1(View view) {
        int score1 = player1;

        //Toast with reminder to enter username if EditText is blank
        EditText p1 = (EditText) findViewById(R.id.namePlayer1);
        EditText p2 = (EditText) findViewById(R.id.namePlayer2);
        if (p1.getText().toString().matches("") || p2.getText().toString().matches("")) {
            Toast.makeText(this, "User name field cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        //Result Message creation
        String scoreMessage1 = "Total score of " + p1.getText().toString() + " is " + score1 + ".\nTotal score of " + p2.getText().toString() + " is " + player2 + ".";
        if (player1 > player2) {
            scoreMessage1 += "\nWinner: " + p1.getText().toString();
        } else if (player2 > player1) {
            scoreMessage1 += "\nWinner: " + p2.getText().toString();
        } else {
            scoreMessage1 += "\nDraw!";
        }
        displayMessage(scoreMessage1);

        TextView scoreTextView1 = (TextView) findViewById(R.id.score_text_view);
        scoreTextView1.setVisibility(View.VISIBLE);

    }

    //This method displays the given quantity value on the screen.
    private void display(int number) {
        TextView quantityTextView1 = (TextView) findViewById(R.id.quantity_text_view1);
        quantityTextView1.setText("" + number);
    }

    private void display2(int number) {
        TextView quantity_text_view2 = (TextView) findViewById(R.id.quantity_text_view2);
        quantity_text_view2.setText("" + number);
    }


    //This method displays the given text on the screen.
    private void displayMessage(String message) {
        TextView scoreTextView1 = (TextView) findViewById(R.id.score_text_view);
        scoreTextView1.setText(message);
    }


    // This method is called when reset button is clicked.
    public void resetScore(View view) {
        player1 = 0;
        player2 = 0;
        String scoreMessage1 = " ";
        display(player1);
        display2(player2);
        displayMessage(scoreMessage1);
        TextView scoreTextView1 = (TextView) findViewById(R.id.score_text_view);
        scoreTextView1.setVisibility(View.GONE);
    }

    // This method is called when the image button is clicked.
    public void displayRules(View view) {
        Intent i = new Intent(this, basketballRules.class);
        startActivity(i);
    }

    // Dismissing keyboard when click outside of EditText in android
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }
}