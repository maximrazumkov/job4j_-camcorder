package ru.job4j.camcoder.dto;

import java.io.Serializable;

public class SourseData implements Serializable {

    private String urlType;
    private String videoUrl;

    public SourseData() {
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
