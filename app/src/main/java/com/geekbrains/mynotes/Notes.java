package com.geekbrains.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {

    private String name;
    private String description;
    private int data;

    protected Notes(Parcel in) {
        name = in.readString();
        description = in.readString();
        data = in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public Notes(String name, int data, String description ) {
        this.name = name;
        this.description = description;
        this.data = data;
    }

    public Notes(int i) {

    }

    public String getName() {
        return name;
    }


    public int getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(data);
    }
}
