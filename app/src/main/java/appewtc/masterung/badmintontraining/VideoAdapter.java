package appewtc.masterung.badmintontraining;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 8/2/2016 AD.
 */
public class VideoAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, titleStrings, detailStrings;

    public VideoAdapter(Context context,
                        String[] iconStrings,
                        String[] titleStrings,
                        String[] detailStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.video_listview, viewGroup, false);

        //Bind Widget
        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView11);
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView17);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView18);

        //Show View
        Picasso.with(context).load(iconStrings[i]).resize(100, 100).into(imageView);
        titleTextView.setText(titleStrings[i]);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
}   // Main Class
