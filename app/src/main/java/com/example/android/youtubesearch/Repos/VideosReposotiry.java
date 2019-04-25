package com.example.android.youtubesearch.Repos;

import android.util.Log;
import android.widget.Toast;


import com.example.android.youtubesearch.API.APIManager;
import com.example.android.youtubesearch.API.Model.VideosResponse.Default;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;
import com.example.android.youtubesearch.API.Model.VideosResponse.VideosResponse;
import com.example.android.youtubesearch.Database.MyDataBase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosReposotiry {

    private static String apiKey = "AIzaSyBrtaoPK0QlOy-HqxBkVWrHpcm7qHaFGzw";

    String part;
    String q;
    String type;



    public VideosReposotiry(String part, String q, String type) {
        this.part = part;
        this.q = q;
        this.type=type;

    }

    public void getVideos (final OnVideosPreparedListener onVideosPreparedListener) {

        APIManager.getAPIs()
                .getVideos(part, q, type, apiKey)
                .enqueue(new Callback<VideosResponse>() {
                    @Override
                    public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {

                        if (response.isSuccessful()) {

                            if (onVideosPreparedListener!= null) {
                                onVideosPreparedListener.onVideosPrepared(response.body().getItems());

                                InsertVideosIntoDataBase thread =
                                        new InsertVideosIntoDataBase(response.body().getItems());

                                thread.start();




                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<VideosResponse> call, Throwable t) {
                        //handle database call
                        GetVideosFromDataBase thread =
                                new GetVideosFromDataBase(onVideosPreparedListener);
                        thread.start();

                    }
                });


    }

    public interface OnVideosPreparedListener {

        public void onVideosPrepared(List<Item> videosList);
    }

    //this is a Background Thread that insert data into database
    class InsertVideosIntoDataBase extends Thread {

        List<Item> mVideos;

        public InsertVideosIntoDataBase(List<Item> videos) {
            mVideos = videos;

        }

        @Override
        public void run() {

            MyDataBase.getInstance()
                    .videoDao()
                    .addVideos(mVideos);

            Log.e("videos thread", "Insertion success");


        }
    }


    //this is a Background Thread that gets data from database
    class GetVideosFromDataBase extends Thread {

        //notify me when you get the sources from the database
        OnVideosPreparedListener mListener;

        GetVideosFromDataBase(OnVideosPreparedListener listener) {
            mListener = listener;

        }


        @Override
        public void run() {

            List<Item> videos = MyDataBase.getInstance()
                    .videoDao()
                    .getAllVideos();


            //when the sources from the database are prepared and ready, notify me
            mListener.onVideosPrepared(videos);

            Log.e("sources thread", "pulling success");


        }
    }







}
