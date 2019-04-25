
package com.example.android.youtubesearch.API.Model.VideosResponse;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
@Entity
public class Item {

    @ColumnInfo
    @Ignore
    @SerializedName("contentDetails")
    private ContentDetails mContentDetails;
    @ColumnInfo
    @SerializedName("etag")
    private String mEtag;
    @ColumnInfo
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private String mId;
    @ColumnInfo
    @SerializedName("kind")
    private String mKind;
    @Ignore
    @ColumnInfo
    @SerializedName("snippet")
    private Snippet mSnippet;
    @ColumnInfo
    @Ignore
    @SerializedName("statistics")
    private Statistics mStatistics;
    @ColumnInfo
    @Ignore
    @SerializedName("status")
    private Status mStatus;

    public ContentDetails getContentDetails() {
        return mContentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        mContentDetails = contentDetails;
    }

    public String getEtag() {
        return mEtag;
    }

    public void setEtag(String etag) {
        mEtag = etag;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public Snippet getSnippet() {
        return mSnippet;
    }

    public void setSnippet(Snippet snippet) {
        mSnippet = snippet;
    }

    public Statistics getStatistics() {
        return mStatistics;
    }

    public void setStatistics(Statistics statistics) {
        mStatistics = statistics;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
