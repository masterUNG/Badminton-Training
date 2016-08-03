package appewtc.masterung.badmintontraining;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckScore extends AppCompatActivity {

    //Explicit
    private ImageView addScoreAImageView, addScoreBImageView;
    private TextView playerATextView, playerBTextView,
            scoreATextView, scoreBTextView;
    private String playerAString, playerBString;
    private int scoreAnInt = 0, scoreBAnInt = 0;
    private boolean statusABoolean = true; //true สภาวะปกติ false สถาวะดิว


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        //Bind Widget
        playerATextView = (TextView) findViewById(R.id.textView22);
        playerBTextView = (TextView) findViewById(R.id.textView23);
        scoreATextView = (TextView) findViewById(R.id.textView20);
        scoreBTextView = (TextView) findViewById(R.id.textView21);
        addScoreAImageView = (ImageView) findViewById(R.id.imageView17);
        addScoreBImageView = (ImageView) findViewById(R.id.imageView18);


        //Show Player
        playerAString = getIntent().getStringExtra("A");
        playerBString = getIntent().getStringExtra("B");
        playerATextView.setText(playerAString);
        playerBTextView.setText(playerBString);

        //Click ADD scoreA
        addScoreAImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScore(scoreATextView, 0);
                soundEffect();
            }   // onClick
        });

        //Click Add scoreB
        addScoreBImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeScore(scoreBTextView, 1);
                soundEffect();
            }   // onClick
        });

    }   // Main Method

    private void soundEffect() {

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.effect_btn_shut);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });


    }   // soundEffect

    private void changeScore(TextView scoreShow, int index) {

        int intShowScore= 0;

        switch (index) {
            case 0:
                scoreAnInt += 1;
                intShowScore = scoreAnInt;
                break;
            case 1:
                scoreBAnInt += 1;
                intShowScore = scoreBAnInt;
        }

        scoreShow.setText(Integer.toString(intShowScore));

        //Check Status
        if ((scoreAnInt == 20) && (scoreBAnInt == 20)) {
            statusABoolean = false; // มีดิวเกิดขึ้น
        }

        //Check Score
        if (statusABoolean) {
            // ปกติ

            if (scoreAnInt == 21) {
                alertScore(playerAString, scoreAnInt, scoreBAnInt);
            } else if (scoreBAnInt == 21) {
                alertScore(playerBString, scoreBAnInt, scoreAnInt);
            }

        } else {
            // ดิว
        }

    }   // checkScore

    private void alertScore(String strWin, int intScoreWin, int intScoreLost) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle("ยินดีในชัยชนะ คุณ " + strWin);
        builder.setMessage("คะแนนของคุณ " +
                Integer.toString(intScoreWin) +
                " : " +
                Integer.toString(intScoreLost));
        builder.setNegativeButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetAll();
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();

    }   // alertScore

    private void resetAll() {

        scoreAnInt = 0;
        scoreBAnInt = 0;
        scoreATextView.setText("0");
        scoreBTextView.setText("0");

    }


}   // Main Class
