package com.example.hvu.sellmark;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Sample_Main extends AppCompatActivity {

    ArrayList<Sample_Class> arraySample;
    ListView lvsample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_main);

        arraySample = new ArrayList<>();
        lvsample = (ListView) findViewById(R.id.lvsample);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://10.0.0.201/~hvu/androidwebservice/sample_list.php");
            }
        });

        lvsample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sampledetail(arraySample.get(i));
            }
        });
    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray =  jsonObject.getJSONArray("Sample");

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject sampleObject = jsonArray.getJSONObject(i);
                    arraySample.add(new Sample_Class(
                            sampleObject.getString("SID"),
                            sampleObject.getString("SName"),
                            sampleObject.getString("SDescription"),
                            sampleObject.getString("SImage")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Sample_Class_Adapter adapter = new Sample_Class_Adapter(
                    getApplicationContext(), R.layout.activity_sample_item_view, arraySample
            );
            lvsample.setAdapter(adapter);
        }
    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void sampledetail(Sample_Class s){
        Intent gotorecordlist = new Intent(Sample_Main.this, Sample_Record_Main.class);
        gotorecordlist.putExtra("SName", s.getSname().toString());
        gotorecordlist.putExtra("SID", s.getSid().toString());
        startActivity(gotorecordlist);
    }



}
