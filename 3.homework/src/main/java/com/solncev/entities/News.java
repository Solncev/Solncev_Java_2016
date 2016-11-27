package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class News {
    private long id;
    private String text;
    private long communityId;
    private long authorId;
    private String createdAt;

    public News(long id, String text, long communityId, long authorId, String createdAt) {
        this(text, communityId, authorId, createdAt);
        this.id = id;
    }

    public News(String text, long communityId, long authorId, String createdAt) {
        this.text = text;
        this.communityId = communityId;
        this.authorId = authorId;
        this.createdAt = createdAt;
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

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
