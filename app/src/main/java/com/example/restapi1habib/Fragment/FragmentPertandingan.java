package com.example.restapi1habib.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.restapi1habib.Adapter.PertandinganAdapter;
import com.example.restapi1habib.Adapter.TeamAdapter;
import com.example.restapi1habib.Api.EventsItem;
import com.example.restapi1habib.Api.ResponsePertandingan;
import com.example.restapi1habib.Api.ResponseTeam;
import com.example.restapi1habib.EndPoint.LeagueRetrofit;
import com.example.restapi1habib.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPertandingan extends Fragment {

    RecyclerView rvpertandingan;
    PertandinganAdapter adapter;
    List<EventsItem> data;


    public FragmentPertandingan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_pertandingan, container, false);
        rvpertandingan = view.findViewById(R.id.rv_pertandingan);
        rvpertandingan.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvpertandingan.setAdapter(adapter);

        getDataPertandingan();

        return view;

    }

    private void getDataPertandingan() {
        LeagueRetrofit.getInstace().getDataPertandingan().enqueue(new Callback<ResponsePertandingan>() {
            @Override
            public void onResponse(Call<ResponsePertandingan> call, Response<ResponsePertandingan> response) {
                if (response.isSuccessful()) {
                    data = response.body().getEvents();
                    adapter = new PertandinganAdapter(getActivity(),data);
                    rvpertandingan.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponsePertandingan> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
