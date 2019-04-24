package com.example.android.youtubesearch.API;


import com.example.android.youtubesearch.API.Model.VideosResponse.VideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {

    @GET("search")
    public Call<VideosResponse> getVideos(@Query("key") String apiKey,
                                          @Query("part") String part,
                                          @Query("q") String q);




}
