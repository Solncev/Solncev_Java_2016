package com.solncev.entities;

/**
 * Created by Марат on 23.11.2016.
 */
public class Message {
    private long id;
    private String text;
    private long sender_id;
    private long recipient_id;
    private String created_at;
    private String status;

    public Message(long id, String text, long sender_id, long recipient_id, String created_at, String status) {
        this.id = id;
        this.text = text;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.created_at = created_at;
        this.status = status;
    }

    public Message(String text, long sender_id, long recipient_id, String created_at, String status) {
        this.text = text;
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.created_at = created_at;
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

    public long getSender_id() {
        return sender_id;
    }

    public void setSender_id(long sender_id) {
        this.sender_id = sender_id;
    }

    public long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(long recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
