package com.example.module_news.fragment;

public class item {

    private String title;
    private String text;

    public item() {
    }

    public item(String title,String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
