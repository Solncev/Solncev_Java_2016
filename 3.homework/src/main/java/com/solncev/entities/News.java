package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class News {
    private long id;
    private String text;
    private long community_id;
    private long author_id;
    private String created_at;

    public News(long id, String text, long community_id, long author_id, String created_at) {
        this.id = id;
        this.text = text;
        this.community_id = community_id;
        this.author_id = author_id;
        this.created_at = created_at;
    }

    public News(String text, long community_id, long author_id, String created_at) {
        this.text = text;
        this.community_id = community_id;
        this.author_id = author_id;
        this.created_at = created_at;
    }

    public News() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(long community_id) {
        this.community_id = community_id;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
