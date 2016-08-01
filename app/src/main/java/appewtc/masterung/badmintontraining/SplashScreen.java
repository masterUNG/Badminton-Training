package appewtc.masterung.badmintontraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    //Explicit
    private ImageView imageView;
    private TextView team1TextView, team2TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView);
        team1TextView = (TextView) findViewById(R.id.textView3);
        team2TextView = (TextView) findViewById(R.id.textView4);

        //Show View
        MyConfig myConfig = new MyConfig();
        imageView.setImageResource(myConfig.getLogoAnInt());
        team1TextView.setText(myConfig.getTeam1String());
        team2TextView.setText(myConfig.getTeam2String());

    }   // Main Method

}   // Main Class
