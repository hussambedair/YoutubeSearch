package com.example.android.youtubesearch.API;


import com.example.android.youtubesearch.API.Model.VideosResponse.VideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {

    @GET("search")
    public Call<VideosResponse> getVideos(@Query("part") String part,
                                          @Query("q") String q,
                                          @Query("type") String type,
                                          @Query("key") String apiKey);




}
