package com.example.myapplication2.buy;

public class dgia {
    private String reviewerName;
    private float rating;
    private String content;

    public dgia(String reviewerName, float rating, String content) {
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.content = content;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
