package appewtc.masterung.badmintontraining;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }   // Main Method

    private class SynCourt extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private GoogleMap courtGoogleMap;
        private static final String urlJSON = "http://swiftcodingthai.com/kan/get_court.php";

        public SynCourt(Context context, GoogleMap courtGoogleMap) {
            this.context = context;
            this.courtGoogleMap = courtGoogleMap;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("kanV3", "JSON ==> " + s);


        }   // onPost

    }   // SynCourt Class


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double lat = 13.738878;
        double lng = 100.627332;
        LatLng latLng = new LatLng(lat, lng);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));


        SynCourt synCourt = new SynCourt(this, mMap);
        synCourt.execute();

    }   // onMapReady

}   // Main Class
