package com.example.android.youtubesearch.Database.DAOs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.youtubesearch.API.Model.VideosResponse.Default;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;

import java.util.List;

@Dao
public interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addVideos(List<Item> videos) ;


    @Query("select * from Item;")
    public List<Item> getAllVideos();


}
