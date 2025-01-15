package com.example.backend.data.database;
import com.example.backend.business.domain.state.NormalUser;
import com.example.backend.data.repository.UserRepository;

public class Database {
    private static Database instance;

    private Database() {

    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
