package com.example.android.youtubesearch.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.youtubesearch.API.Model.VideosResponse.Item;
import com.example.android.youtubesearch.API.Model.VideosResponse.Snippet;
import com.example.android.youtubesearch.R;

import java.util.List;

public class VideosRecyclerAdapter extends
        RecyclerView.Adapter<VideosRecyclerAdapter.ViewHolder> {

    List<Item> mVideos;



    public VideosRecyclerAdapter( List<Item> mVideos) {
        this.mVideos = mVideos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int postion) {
        final Item video = mVideos.get(postion);

        viewHolder.videoName.setText(video.getSnippet().getTitle());

        //attach image by url using Glide library
        Glide.with(viewHolder.itemView)
                .load(video.getSnippet().getThumbnails().getDefault().getUrl()).into(viewHolder.videoImage);


    }

    @Override
    public int getItemCount() {
        if (mVideos == null) {
            return 0;
        }
        return mVideos.size();
    }

    public void changeData (List <Item> videos) {
        mVideos = videos;
        notifyDataSetChanged();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView videoName;
        ImageView videoImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videoName = itemView.findViewById(R.id.video_name_text_view);
            videoImage = itemView.findViewById(R.id.video_image_view);
        }
    }



}
