package com.example.nisa.recyclerview.retrofit;

import com.example.nisa.recyclerview.model.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("music_albums")
    Call<ArrayList<Album>> getAlbums();
}
