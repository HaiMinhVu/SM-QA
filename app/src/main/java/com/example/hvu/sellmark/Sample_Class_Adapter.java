package com.example.hvu.sellmark;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Sample_Class_Adapter extends ArrayAdapter {

    ArrayList<Sample_Class> arraySample;
    Context context;
    int resource;

    public Sample_Class_Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Sample_Class> arraySample) {
        super(context, resource, arraySample);
        this.arraySample = arraySample;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_sample_item_view, null, true);

        }

        Sample_Class s = (Sample_Class) getItem(position);

        ImageView imsample = (ImageView) convertView.findViewById(R.id.imsample);
        Picasso.get().load(s.getSimage()).into(imsample);

        TextView tvsname = (TextView) convertView.findViewById(R.id.tvsname);
        tvsname.setText(s.getSname());

        TextView tvsdescription = (TextView) convertView.findViewById(R.id.tvsdescription);
        tvsdescription.setText(s.getSdescription());

        return convertView;
    }
}
