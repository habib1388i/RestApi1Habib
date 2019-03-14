package com.example.restapi1habib.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi1habib.Api.TeamsItem;
import com.example.restapi1habib.Detail.DetailTeam;
import com.example.restapi1habib.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    Context contextteam;
    List<TeamsItem> datateam;
    public TeamAdapter(Context context, List<TeamsItem> data) {
        contextteam = context;
        datateam = data;
    }


    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TeamViewHolder(LayoutInflater.from(contextteam).inflate(R.layout.tampilan_teams,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder,final int i) {
        teamViewHolder.tvteam.setText(datateam.get(i).getStrTeam());
        Picasso.get().load(datateam.get(i).getStrTeamBadge()).into(teamViewHolder.imgteam);
        teamViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contextteam, DetailTeam.class);
                intent.putExtra("detail",datateam.get(i).getStrDescriptionEN());
                intent.putExtra("tittle",datateam.get(i).getStrTeam());
                intent.putExtra("image",datateam.get(i).getStrTeamBadge());
                contextteam.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datateam.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imgteam;
        TextView tvteam;
        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imgteam = itemView.findViewById(R.id.img_team);
            tvteam = itemView.findViewById(R.id.tv_team);
        }
    }
}
