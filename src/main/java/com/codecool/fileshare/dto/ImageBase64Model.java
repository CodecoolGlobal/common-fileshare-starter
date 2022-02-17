package com.codecool.fileshare.dto;


public class ImageBase64Model {
    private String content;

    public ImageBase64Model() {
    }

    public ImageBase64Model(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
