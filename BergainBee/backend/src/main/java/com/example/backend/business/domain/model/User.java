package com.example.backend.business.domain.model;

import com.example.backend.business.domain.state.Admin;
import com.example.backend.business.domain.state.IUserState;
import com.example.backend.business.domain.state.NormalUser;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class User implements IUserState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<BaseProduct> favorites;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User() {

    }


    public int getUserID(){
        return userID;
    }
    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public List<BaseProduct> getFavorites() {
        return favorites;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void performAction(String action) {
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavorites(List<BaseProduct> favorites) {
        this.favorites = favorites;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

}
