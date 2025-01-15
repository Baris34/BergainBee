package com.example.backend.data.repository;

import com.example.backend.business.domain.model.Notification;
import com.example.backend.business.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUser(User user);

    List<Notification> findByUserUserID(int userID);
}
