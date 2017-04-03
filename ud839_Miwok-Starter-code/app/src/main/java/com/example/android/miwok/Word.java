package com.example.android.miwok;



public class Word {

    private String mdefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=No_Imgae_Provided;
    private int mAudioResourceId;

    // TO check whether we have passed image or not we are creating a stici private variable
    private static final int No_Imgae_Provided=-1;

    public Word(String defaultTranslation, String miwokTranslation, int audioResource){
        mdefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=audioResource;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageId, int audioResource){
        mdefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=imageId;
        mAudioResourceId=audioResource;
    }

    public String getdefaultTranslation(){
        return mdefaultTranslation;
    }

    public String getmiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=No_Imgae_Provided;
    }

    public int getmAudioResourceId(){
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mdefaultTranslation+ '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
