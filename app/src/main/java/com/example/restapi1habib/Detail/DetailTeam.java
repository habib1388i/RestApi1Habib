package com.example.restapi1habib.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi1habib.R;
import com.squareup.picasso.Picasso;

public class DetailTeam extends AppCompatActivity {

    ImageView imgdetailclub;
    TextView tv1 , tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);
        imgdetailclub = findViewById(R.id.img_detailteam);
        tv1 = findViewById(R.id.tv_namateamdetail);
        tv2 = findViewById(R.id.tv_detailteam);

        tv1.setText(getIntent().getStringExtra("tittle"));
        tv2.setText(getIntent().getStringExtra("detail"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(imgdetailclub);
    }
}
