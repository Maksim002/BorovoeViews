package com.timelysoft.borovoe.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IntertainmentModel implements Parcelable {
    private String imagePath;
    private String title;


    public static final Creator<IntertainmentModel> CREATOR = new Creator<IntertainmentModel>() {
        @Override
        public IntertainmentModel createFromParcel(Parcel in) {
            return new IntertainmentModel(in);
        }

        @Override
        public IntertainmentModel[] newArray(int size) {
            return new IntertainmentModel[size];
        }
    };

    protected IntertainmentModel(Parcel in) {
        imagePath = in.readString();
        title = in.readString();
    }

    public String getImagePath() {
        return imagePath;
    }


    public String getTitle() {
        return title;
    }


    public IntertainmentModel(String imagePath, String title) {
        this.imagePath = imagePath;
        this.title = title;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imagePath);
        dest.writeString(title);
    }
}
