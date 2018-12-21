package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_RESOURCE_PROVIDED;
    private int mAudioResourceId;
    private static final int NO_IMAGE_RESOURCE_PROVIDED = -1;

    public Word(String mMiwokTranslation, String mDefaultTranslation,int mAudioResourceId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mMiwokTranslation, String mDefaultTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmMiwokTranslation() {

        return mMiwokTranslation;
    }

    public String getmDefaultTranslation() {

        return mDefaultTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_RESOURCE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
