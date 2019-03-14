package com.example.restapi1habib.EndPoint;

import com.example.restapi1habib.Api.ResponsePertandingan;
import com.example.restapi1habib.Api.ResponseTeam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeagueService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponseTeam> getDataTeam();

    @GET("eventspastleague.php?id=4328")
    Call<ResponsePertandingan> getDataPertandingan();


}
