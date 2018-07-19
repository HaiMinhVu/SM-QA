package com.example.hvu.sellmark;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Sample_Record_Class_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Sample_Record_Class> arraySampleRecord;

    public Sample_Record_Class_Adapter(Context context, int layout, List<Sample_Record_Class> arraySampleRecord) {
        this.context = context;
        this.layout = layout;
        this.arraySampleRecord = arraySampleRecord;
    }

    @Override
    public int getCount() {
        return arraySampleRecord.size();
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        Sample_Record_Class sr = arraySampleRecord.get(i);

        TextView tvvendor = (TextView) view.findViewById(R.id.tvvendor);
        tvvendor.setText(sr.getEname());

        return view;
    }
}
