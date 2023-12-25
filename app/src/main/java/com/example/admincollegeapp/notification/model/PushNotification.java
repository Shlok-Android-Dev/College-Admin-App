package com.example.admincollegeapp.notification.model;

public class PushNotification {
    private NotifcationData data;
    private String to;

    public PushNotification(NotifcationData data, String to) {
        this.data = data;
        this.to = to;
    }

    public NotifcationData getData() {
        return data;
    }

    public void setData(NotifcationData data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
