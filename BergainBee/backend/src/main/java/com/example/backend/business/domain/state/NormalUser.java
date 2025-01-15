package com.example.backend.business.domain.state;
import com.example.backend.business.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class NormalUser implements IUserState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public NormalUser(String username, String email, String password) {
        this.username=username;
        this.password=password;
        this.email=email;
    }

    public NormalUser() {

    }

    @Override
    public void performAction(String action) {
        System.out.println("Normal User performing action: " + action);
    }
}
