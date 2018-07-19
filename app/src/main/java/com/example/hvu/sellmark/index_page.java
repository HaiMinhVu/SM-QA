package com.example.hvu.sellmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class index_page extends AppCompatActivity {

    Button btnproject, btnvendor, btnsample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

        mapped();

        btnsample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosample = new Intent(index_page.this, Sample_Main.class);
                startActivity(gotosample);
            }
        });

    }

    private void mapped(){
        btnproject = (Button) findViewById(R.id.btnproject);
        btnsample = (Button) findViewById(R.id.btnsample);
        btnvendor = (Button) findViewById(R.id.btnvendor);

    }
}
