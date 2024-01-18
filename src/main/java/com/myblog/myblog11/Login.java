package com.myblog.myblog11;
//CONVERT OBJECTS TO DTOs  USING STREAM API PART 2
public class Login {
    private String userName;
    private String password;

    public Login(String username, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
