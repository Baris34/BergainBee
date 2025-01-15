package com.example.backend.business.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationID;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification(String message, User user) {
    }

    public Notification() {

    }

    public void sendNotification() {
        System.out.println("Sending notification to user: " + user.getUsername());
        System.out.println("Message: " + message);
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
