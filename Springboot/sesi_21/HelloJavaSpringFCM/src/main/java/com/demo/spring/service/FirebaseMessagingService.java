package com.demo.spring.service;

import javax.management.Notification;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import com.demo.spring.pojo.Note;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;

@Service
public class FirebaseMessagingService {
	
	private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(Note note, String topic) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }
}
