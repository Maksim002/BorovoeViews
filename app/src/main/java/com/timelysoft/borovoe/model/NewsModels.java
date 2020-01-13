package com.timelysoft.borovoe.model;

public class NewsModels {

    private String title;
    private String data;
    private String content;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String fourthImage;

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public String getContent() {
        return content;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public String getFourthImage() {
        return fourthImage;
    }

    public NewsModels(String title, String data, String content, String firstImage, String secondImage, String thirdImage, String fourthImage) {
        this.title = title;
        this.data = data;
        this.content = content;
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourthImage = fourthImage;
    }

}
