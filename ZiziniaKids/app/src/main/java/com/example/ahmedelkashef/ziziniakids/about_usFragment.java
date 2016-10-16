package com.example.ahmedelkashef.ziziniakids;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by crema on 14/10/2016.
 */
public class about_usFragment extends Fragment {

    ListView about_us_list ;
    about_usAdapter adapter;
    public static String FACEBOOK_URL = "https://www.facebook.com/genius.kids.community/";
    String latitude, longitude;
    String url ="https://www.youtube.com/channel/UChdeAO0naFewi8leXaCquOQ";
    //String gmial = "geniuskidscommunity@gmail.com";

    public void shareToGMail(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{email} );
       // emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.setType("text/plain");
        //emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
        final PackageManager pm = getContext().getPackageManager();
        final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
        ResolveInfo best = null;
        for(final ResolveInfo info : matches)
            if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                best = info;
        if (best != null)
            emailIntent.setClassName(best.activityInfo.packageName, best.activityInfo.name);
        getContext().startActivity(emailIntent);
    }


    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri;
        try {
            pm.getPackageInfo("com.facebook.katana", 0);
            // http://stackoverflow.com/a/24547437/1048340
            uri = Uri.parse("fb://facewebmodal/f?href=" + url);
        } catch (PackageManager.NameNotFoundException e) {
            uri = Uri.parse(url);
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
/*textcontent.setText(Html.fromHtml(item.get_text()));
    textcontent.setAutoLinkMask(Linkify.WEB_URLS);*/
        String[] data = {
                "Youtube",
                "Facebook",
                "Location (عين شمس)",
                "Location (التجمع)",
                "01112918913",
                "geniuskidscommunity@gmail.com"
        };

      View  rootView = inflater.inflate(R.layout.about_us, container, false);
        about_us_list = (ListView) rootView.findViewById(R.id.listView);
        adapter = new about_usAdapter(getActivity(), Arrays.asList(data));
        about_us_list.setAdapter(adapter);

        about_us_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = null;
                    try {
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setPackage("com.google.android.youtube");
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }

                } else if (position == 1) {
                    Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                    PackageManager packageManager = getContext().getPackageManager();
                    facebookIntent = newFacebookIntent(packageManager, FACEBOOK_URL);
                    startActivity(facebookIntent);
                } else if (position == 2) {
                    String uri = String.format(Locale.ENGLISH, "geo:30.129548,31.321064?q=22 El-Shaheed Ahmed Esmat, Ain Shams Sharkeya, Qism Ain Shams, Cairo Governorate, Egypt", latitude, longitude);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                } else if (position == 3) {
                    String uri = String.format(Locale.ENGLISH, "geo:0,0?q=30.0041986,31.489694166666666&z=16(genius kids)", latitude, longitude);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:01112918914"));
                    startActivity(intent);
                }
                else if (position == 5) {
                    shareToGMail("geniuskidscommunity@gmail.com");
                }
            }
        });

        return  rootView;
    }
}
