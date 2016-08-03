package appewtc.masterung.badmintontraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoPlayer extends AppCompatActivity {

    //Explicit
    private EditText playerAEditText, playerBEditText;
    private Button playButton;
    private String playerAString, playerBString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        //Bind Widget
        playerAEditText = (EditText) findViewById(R.id.editText);
        playerBEditText = (EditText) findViewById(R.id.editText2);
        playButton = (Button) findViewById(R.id.button3);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerAString = playerAEditText.getText().toString().trim();
                playerBString = playerBEditText.getText().toString().trim();

                if (playerAString.equals("")) {
                    playerAString = "Player A";
                }

                if (playerBString.equals("")) {
                    playerBString = "Player B";
                }


                Log.d("kanV2", "A ==> " + playerAString);
                Log.d("kanV2", "B ==> " + playerBString);

                Intent intent = new Intent(TwoPlayer.this, CheckScore.class);
                intent.putExtra("A", playerAString);
                intent.putExtra("B", playerBString);
                startActivity(intent);
                finish();


            }   // onClick
        });

    }   // Main Method

}   // Main Class
