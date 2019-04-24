
package com.example.android.youtubesearch.API.Model.VideosResponse;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Status {

    @SerializedName("embeddable")
    private Boolean mEmbeddable;
    @SerializedName("license")
    private String mLicense;
    @SerializedName("privacyStatus")
    private String mPrivacyStatus;
    @SerializedName("publicStatsViewable")
    private Boolean mPublicStatsViewable;
    @SerializedName("uploadStatus")
    private String mUploadStatus;

    public Boolean getEmbeddable() {
        return mEmbeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        mEmbeddable = embeddable;
    }

    public String getLicense() {
        return mLicense;
    }

    public void setLicense(String license) {
        mLicense = license;
    }

    public String getPrivacyStatus() {
        return mPrivacyStatus;
    }

    public void setPrivacyStatus(String privacyStatus) {
        mPrivacyStatus = privacyStatus;
    }

    public Boolean getPublicStatsViewable() {
        return mPublicStatsViewable;
    }

    public void setPublicStatsViewable(Boolean publicStatsViewable) {
        mPublicStatsViewable = publicStatsViewable;
    }

    public String getUploadStatus() {
        return mUploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        mUploadStatus = uploadStatus;
    }

}
