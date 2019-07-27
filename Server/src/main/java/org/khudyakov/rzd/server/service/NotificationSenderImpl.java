package org.khudyakov.rzd.server.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderImpl implements NotificationSender {
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Override
    public void sendMessage(String token, String text) {
        Message message = Message.builder()
                .setToken(token)
                .putData("text", text)
                .build();
        try {
            firebaseMessaging.send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}
