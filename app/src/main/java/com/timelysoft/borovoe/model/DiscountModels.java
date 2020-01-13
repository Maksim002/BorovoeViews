package com.timelysoft.borovoe.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DiscountModels implements Parcelable {
    private String imagePath;
    private String title;
    private String content;
    private String adContent;

    protected DiscountModels(Parcel in) {
        imagePath = in.readString();
        title = in.readString();
        content = in.readString();
        adContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePath);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(adContent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DiscountModels> CREATOR = new Creator<DiscountModels>() {
        @Override
        public DiscountModels createFromParcel(Parcel in) {
            return new DiscountModels(in);
        }

        @Override
        public DiscountModels[] newArray(int size) {
            return new DiscountModels[size];
        }
    };

    public String getImagePath() {
        return imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getAdContent() {
        return adContent;
    }

    public String getContent() {
        return content;
    }

    public DiscountModels(String imagePath, String title, String content, String adContent) {
        this.imagePath = imagePath;
        this.title = title;
        this.content = content;
        this.adContent = adContent;
    }
}
