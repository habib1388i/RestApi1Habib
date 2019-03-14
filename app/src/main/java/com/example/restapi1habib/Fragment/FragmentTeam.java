package com.example.restapi1habib.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.restapi1habib.Adapter.TeamAdapter;
import com.example.restapi1habib.Api.ResponseTeam;
import com.example.restapi1habib.Api.TeamsItem;
import com.example.restapi1habib.EndPoint.LeagueRetrofit;
import com.example.restapi1habib.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTeam extends Fragment {
    RecyclerView rvteam;
    TeamAdapter adapter;
    List<TeamsItem> data;

    public FragmentTeam() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_team, container, false);
        rvteam = view.findViewById(R.id.rv_team);
        rvteam.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvteam.setAdapter(adapter);

        getDataTeam();

        return view;

    }

    private void getDataTeam() {
        LeagueRetrofit.getInstace().getDataTeam().enqueue(new Callback<ResponseTeam>() {
            @Override
            public void onResponse(Call<ResponseTeam> call, Response<ResponseTeam> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new TeamAdapter(getActivity(), data);
                    rvteam.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<ResponseTeam> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
