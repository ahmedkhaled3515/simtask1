package com.example.simproject1;

public class Word {
    private String arabic;
    private String translation;
    private int image =NO_IMAG_PROVIDED;
    private static final int NO_IMAG_PROVIDED=-1;
    private int pronounce;
    public Word(String arabic, String trans,int sound)
    {
        this.arabic=arabic;
        translation=trans;
        pronounce=sound;
    }
    public Word(String arabic, String trans, int image,int sound)
    {
        this.arabic=arabic;
        translation=trans;
        this.image=image;
        pronounce=sound;
    }
    public String getArabic(){
        return arabic;
    }
    public String getTrans(){
        return translation;
    }
    public int getImageRes(){ return image; }
    public boolean hasImage()
    {
        return image!=NO_IMAG_PROVIDED;
    }
    public int getSoundres(){return pronounce;}
}
