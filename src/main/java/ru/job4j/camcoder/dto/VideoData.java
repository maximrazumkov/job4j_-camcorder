package ru.job4j.camcoder.dto;

import java.io.Serializable;

public class VideoData implements Serializable {

    private int id;
    private String urlType;
    private String videoUrl;
    private String value;
    private int ttl;

    public VideoData() {
    }

    public VideoData(int id, SourseData sourse, TokenData token) {
        this.id = id;
        this.urlType = sourse.getUrlType();
        this.videoUrl = sourse.getVideoUrl();
        this.value = token.getValue();
        this.ttl = token.getTtl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
}
