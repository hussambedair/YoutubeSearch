package com.example.android.youtubesearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.youtubesearch.API.APIManager;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;
import com.example.android.youtubesearch.API.Model.VideosResponse.Snippet;
import com.example.android.youtubesearch.API.Model.VideosResponse.VideosResponse;
import com.example.android.youtubesearch.Adapters.VideosRecyclerAdapter;
import com.example.android.youtubesearch.Repos.VideosReposotiry;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView videosRecyclerView;
    VideosRecyclerAdapter videosAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Item> videos;

    VideosReposotiry videosReposotiry;
    String part = "snippet";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        videosRecyclerView = findViewById(R.id.videos_recycler_view);
        videosAdapter = new VideosRecyclerAdapter(null);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        videosRecyclerView.setAdapter(videosAdapter);
        videosRecyclerView.setLayoutManager(layoutManager);






    }

    VideosReposotiry.OnVideosPreparedListener onVideosPreparedListener = new VideosReposotiry.OnVideosPreparedListener() {
        @Override
        public void onVideosPrepared(final List<Item> videos) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    videosAdapter.changeData(videos);
                }
            });

        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //Perform the final search

                videosReposotiry = new VideosReposotiry(part, s);
                videosReposotiry.getVideos(onVideosPreparedListener);



                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // Text has changed, apply filtering?

                return false;
            }
        });



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
