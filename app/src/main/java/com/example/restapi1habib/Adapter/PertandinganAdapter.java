package com.example.restapi1habib.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi1habib.Api.EventsItem;
import com.example.restapi1habib.Detail.DetailPertandingan;
import com.example.restapi1habib.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PertandinganAdapter extends RecyclerView.Adapter <PertandinganAdapter.PertandinganViewHolder>{
    Context contextpertandingan;
    List<EventsItem> datapertandingan;
    public PertandinganAdapter(Context context, List<EventsItem> data) {
        contextpertandingan = context;
        datapertandingan = data;

    }

    @NonNull
    @Override
    public PertandinganViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PertandinganViewHolder(LayoutInflater.from(contextpertandingan).inflate(R.layout.tampilan_pertandingan,null));
    }

    @Override
    public void onBindViewHolder(@NonNull PertandinganViewHolder pertandinganViewHolder,final int i) {

        pertandinganViewHolder.tvnamaclub.setText(datapertandingan.get(i).getStrHomeTeam());
        pertandinganViewHolder.tvnamaclub2.setText(datapertandingan.get(i).getStrAwayTeam());
        pertandinganViewHolder.skor.setText(datapertandingan.get(i).getIntHomeScore());
        pertandinganViewHolder.skor2.setText(datapertandingan.get(i).getIntAwayScore());
        pertandinganViewHolder.tanggal.setText(datapertandingan.get(i).getDateEvent());

        pertandinganViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextpertandingan, DetailPertandingan.class);
                intent.putExtra("namaclub1",datapertandingan.get(i).getStrHomeTeam());
                intent.putExtra("namaclub2",datapertandingan.get(i).getStrAwayTeam());
                intent.putExtra("skor",datapertandingan.get(i).getIntHomeScore());
                intent.putExtra("skor2",datapertandingan.get(i).getIntAwayScore());
                intent.putExtra("detail",datapertandingan.get(i).getStrHomeGoalDetails());
                contextpertandingan.startActivity(intent);


            }
        });

//        Picasso.get().load(datapertandingan.get(i).)




    }

    @Override
    public int getItemCount() {
        return datapertandingan.size();
    }

    public class PertandinganViewHolder extends RecyclerView.ViewHolder {
        ImageView imglogo, imglogo2;
        TextView tvnamaclub, tvnamaclub2, skor,skor2,tanggal;
        public PertandinganViewHolder(@NonNull View itemView) {
            super(itemView);
            imglogo = itemView.findViewById(R.id.img_pertandingan);
            imglogo2 = itemView.findViewById(R.id.img_pertandingan2);
            tvnamaclub = itemView.findViewById(R.id.tv_namapertandingan);
            tvnamaclub2 = itemView.findViewById(R.id.tv_namapertandingan2);
            skor = itemView.findViewById(R.id.tv_skor);
            skor2 = itemView.findViewById(R.id.tv_skor2);
            tanggal = itemView.findViewById(R.id.tv_tanggalpertandinganangka);
        }
    }
}
