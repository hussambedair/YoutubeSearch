package com.example.android.youtubesearch.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.example.android.youtubesearch.API.Model.VideosResponse.Default;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;
import com.example.android.youtubesearch.Database.DAOs.VideoDao;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {


   public abstract VideoDao videoDao();

   private static MyDataBase myDataBase;

   public static void init(Context context) {

       if (myDataBase == null) { //Create new object

           myDataBase= Room.databaseBuilder(context.getApplicationContext(),
                   MyDataBase.class, "Video-Database")
                   //.allowMainThreadQueries() //this will allow us do the database calls in the main thread, but it is not a good practice
                   .build();

       }

   }

    public static MyDataBase getInstance() {
       return myDataBase;

    }






}
