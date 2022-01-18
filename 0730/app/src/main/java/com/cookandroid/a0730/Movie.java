package com.cookandroid.a0730;

import android.graphics.drawable.Drawable;

public class Movie {
    Drawable image;
    String title;
    String genre;

    public Movie(Drawable image, String title, String genre){
        this.genre=genre;
        this.image=image;
        this.title=title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
