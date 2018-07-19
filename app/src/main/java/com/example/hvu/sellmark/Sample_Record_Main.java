package com.example.hvu.sellmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sample_Record_Main extends AppCompatActivity {

    TextView tvrecordlist;
    String sname, sid;
    ListView lvsamplerecord;
    ArrayList<Sample_Record_Class> arraySampleRecord;
    Sample_Record_Class_Adapter sampleRecordClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_record_main);

        tvrecordlist = (TextView) findViewById(R.id.tvsamplerecordlist);

        Intent i = getIntent();
        sname = i.getStringExtra("SName");
        sid = i.getStringExtra("SID");
        tvrecordlist.append(sname);

        lvsamplerecord = (ListView) findViewById(R.id.lvsamplerecord);
        arraySampleRecord = new ArrayList<>();
        sampleRecordClassAdapter = new Sample_Record_Class_Adapter(this, R.layout.activity_sample_record_item_view, arraySampleRecord);
        lvsamplerecord.setAdapter(sampleRecordClassAdapter);

        getRecordListBySampleID("http://10.0.0.201/~hvu/androidwebservice/sample_record_list.php");

        lvsamplerecord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                writereviewforeachrecord(arraySampleRecord.get(i));
            }
        });
    }

    private void getRecordListBySampleID(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("SampleRecord");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject recordObject = jsonArray.getJSONObject(i);
                                arraySampleRecord.add(new Sample_Record_Class(
                                        recordObject.getString("SRID"),
                                        recordObject.getString("EName"),
                                        recordObject.getString("RequestBy"),
                                        recordObject.getString("Quantity"),
                                        recordObject.getString("Price"),
                                        recordObject.getString("Type")
                                        )
                                );
                            }
                            sampleRecordClassAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            // get values from user input and pass to method POST php
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("SID", sid);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void writereviewforeachrecord(Sample_Record_Class sr){
        Toast.makeText(this, sr.getSrid(), Toast.LENGTH_SHORT).show();
    }

}
