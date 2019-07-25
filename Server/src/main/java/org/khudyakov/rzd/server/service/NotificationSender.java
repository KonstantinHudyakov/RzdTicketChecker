package org.khudyakov.rzd.server.service;

public interface NotificationSender {
    void sendMessage(String token, String text);
}
