package appewtc.masterung.badmintontraining;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainHub extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView hub1ImageView, hub2ImageView, hub3ImageView,
            hub4ImageView, hub5ImageView, hub6ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);

        //Bind Widget
        hub1ImageView = (ImageView) findViewById(R.id.imageView2);
        hub2ImageView = (ImageView) findViewById(R.id.imageView3);
        hub3ImageView = (ImageView) findViewById(R.id.imageView4);
        hub4ImageView = (ImageView) findViewById(R.id.imageView5);
        hub5ImageView = (ImageView) findViewById(R.id.imageView6);
        hub6ImageView = (ImageView) findViewById(R.id.imageView7);

        hub1ImageView.setOnClickListener(this);
        hub2ImageView.setOnClickListener(this);
        hub3ImageView.setOnClickListener(this);
        hub4ImageView.setOnClickListener(this);
        hub5ImageView.setOnClickListener(this);
        hub6ImageView.setOnClickListener(this);

    }   // Main Method


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.imageView2:   //to กฎกติกา
                startActivity(new Intent(MainHub.this, RulesActivity.class));
                break;
            case R.id.imageView3:   // to ดู วิดีโอ
                startActivity(new Intent(MainHub.this, VideoActivity.class));
                break;
            case R.id.imageView4:   // to นับคะแนน
                confirmCountScore();
                break;
            case R.id.imageView5:   // to แสดงแผนที่ สนาม
                startActivity(new Intent(MainHub.this, MapsActivity.class));
                break;
            case R.id.imageView6:
                break;
            case R.id.imageView7:
                break;
        }   // switch

    }   // onClick

    private void confirmCountScore() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle("นับคะแนน");
        builder.setMessage("ประเภทการแข่ง คู่ หรือ เดี่ยว");
        builder.setNegativeButton("คู่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("เดี่ยว", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }   // confirm

}   // Main Class
