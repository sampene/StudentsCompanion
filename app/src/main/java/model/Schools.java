package model;


import android.graphics.Bitmap;

public class Schools {
    private String mName;
    private Bitmap mThumbnail;

    public Schools(Bitmap image, String title) {
        super();
        this.mThumbnail = image;
        this.mName = title;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.mThumbnail = thumbnail;
    }
}
