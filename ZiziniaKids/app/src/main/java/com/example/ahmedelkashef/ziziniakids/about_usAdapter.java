package com.example.ahmedelkashef.ziziniakids;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by crema on 14/10/2016.
 */
public class about_usAdapter extends ArrayAdapter<String>  {


    public about_usAdapter(Activity context, List<String> objects) {
        super(context, 0,objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position

         String item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.about_us_adapter, parent, false);
        }

        final ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView2);

        TextView titleview = (TextView) convertView.findViewById(R.id.textView2);
        titleview.setText(item);
        if(item== "Youtube")
        {
            imgView.setImageResource(R.drawable.youtube);
        }
        else if(item== "Facebook")
        {
            imgView.setImageResource(R.drawable.facebook);
        }
        else if(item== "Location (عين شمس)" ||item== "Location (التجمع)")
        {
            imgView.setImageResource(R.drawable.google_maps);
        }
        else if(item== "01112918913")
        {
            imgView.setImageResource(R.drawable.telephone);
        }
        else if (item =="geniuskidscommunity@gmail.com")
        {
            imgView.setImageResource(R.drawable.gmail);
        }

        return convertView;
    }


}

/*
public class movie_adapter extends ArrayAdapter<movie> {

    public movie_adapter(Activity context, List<movie> Movie) {
        super(context, 0, Movie);
    }




    @Override


    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        movie movies = getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_items, parent, false);
        }

        final ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);
        final String IMAGE_URL = "http://image.tmdb.org/t/p/w185" + movies.getPoster_url();

        Picasso.with(getContext()).load(IMAGE_URL)
                .into(imgView);


        TextView titleview = (TextView) convertView.findViewById(R.id.textView);
        titleview.setText(movies.getTitle());
        return convertView;
    }


}
*/
