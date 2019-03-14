package com.example.restapi1habib.EndPoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeagueRetrofit {
    public static String url = "https://www.thesportsdb.com/api/v1/json/1/";
    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static LeagueService getInstace (){

        return setInit().create(LeagueService.class);
    }
}
