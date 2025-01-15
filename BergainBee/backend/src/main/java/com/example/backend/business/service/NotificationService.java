package com.example.backend.business.service;

import com.example.backend.business.domain.model.Notification;
import com.example.backend.business.domain.model.User;
import com.example.backend.data.repository.NotificationRepository;
import com.example.backend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public void sendNotification(int userId, String message) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Notification notification = new Notification(message, user);
            notificationRepository.save(notification);
            notification.sendNotification();
        }
    }

    public List<Notification> getNotificationsForUser(int userId) {
        return notificationRepository.findByUserUserID(userId);
    }
}