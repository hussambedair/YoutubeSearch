
package com.example.android.youtubesearch.API.Model.VideosResponse;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Localized {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("title")
    private String mTitle;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
