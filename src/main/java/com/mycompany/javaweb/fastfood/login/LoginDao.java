package com.mycompany.javaweb.fastfood.login;

import com.mycompany.javaweb.fastfood.DB;

public class LoginDao {
    public boolean login(String username, String password) {
        return DB.users.entrySet().stream()
                .filter(u -> u.getKey().equals(username) && u.getValue().equals(password))
                .findAny()
                .isPresent();
    }
}
