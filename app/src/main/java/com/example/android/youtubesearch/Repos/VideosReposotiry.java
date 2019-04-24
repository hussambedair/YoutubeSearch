package com.example.android.youtubesearch.Repos;

import android.util.Log;


import com.example.android.youtubesearch.API.APIManager;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;
import com.example.android.youtubesearch.API.Model.VideosResponse.VideosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosReposotiry {

    private static String apiKey = "AIzaSyBrtaoPK0QlOy-HqxBkVWrHpcm7qHaFGzw";

    String part;
    String q;



    public VideosReposotiry(String part, String q) {
        this.part = part;
        this.q = q;

    }

    public void getVideos (final OnVideosPreparedListener onVideosPreparedListener) {

        APIManager.getAPIs()
                .getVideos(apiKey,part, q)
                .enqueue(new Callback<VideosResponse>() {
                    @Override
                    public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {

                        if (response.isSuccessful()) {
                            if (onVideosPreparedListener!= null) {
                                onVideosPreparedListener.onVideosPrepared(response.body().getItems());

                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<VideosResponse> call, Throwable t) {
                        //handle database call

                    }
                });


    }

    public interface OnVideosPreparedListener {

        public void onVideosPrepared(List<Item> videosList);
    }







}
