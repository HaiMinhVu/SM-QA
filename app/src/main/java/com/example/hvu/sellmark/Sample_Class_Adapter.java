package com.example.hvu.sellmark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

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

    
}
