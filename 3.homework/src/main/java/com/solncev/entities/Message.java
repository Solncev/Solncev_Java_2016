package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Message {
    private long id;
    private String text;
    private long senderId;
    private long recipientId;
    private String createdAt;
    private String status;

    public Message(long id, String text, long senderId, long recipientId, String createdAt, String status) {
        this(text, senderId, recipientId, createdAt, status);
        this.id = id;
    }

    public Message(String text, long senderId, long recipientId, String createdAt, String status) {
        this.text = text;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Message() {

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

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    public String getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(String created_at) {
        this.createdAt = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
