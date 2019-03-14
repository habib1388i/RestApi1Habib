package com.example.restapi1habib.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi1habib.R;

public class DetailPertandingan extends AppCompatActivity {

    TextView tv1 , tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertandingan);
        tv1 = findViewById(R.id.tv_namaclubpertandingan);
        tv2 = findViewById(R.id.tv_namaclubpertandingan2);
        tv3 = findViewById(R.id.tv_skor);
        tv4 = findViewById(R.id.tv_skor2);
        tv5 = findViewById(R.id.tv_detailpertandingan);

        tv1.setText(getIntent().getStringExtra("namaclub1"));
        tv2.setText(getIntent().getStringExtra("namaclub2"));
        tv3.setText(getIntent().getStringExtra("skor"));
        tv4.setText(getIntent().getStringExtra("skor2"));
        tv5.setText(getIntent().getStringExtra("detail"));

    }
}
