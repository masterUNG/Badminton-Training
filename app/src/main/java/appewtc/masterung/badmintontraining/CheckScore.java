package appewtc.masterung.badmintontraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckScore extends AppCompatActivity {

    //Explicit
    private ImageView addScoreAImageView, addScoreBImageView;
    private TextView playerATextView, playerBTextView;
    private String playerAString, playerBString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        //Bind Widget
        playerATextView = (TextView) findViewById(R.id.textView22);
        playerBTextView = (TextView) findViewById(R.id.textView23);

        //Show Player
        playerAString = getIntent().getStringExtra("A");
        playerBString = getIntent().getStringExtra("B");
        playerATextView.setText(playerAString);
        playerBTextView.setText(playerBString);

    }   // Main Method



}   // Main Class
