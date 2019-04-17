package com.jonathan.user.Services;

public class UserRequest {
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;

    public UserRequest(String name, String lastName, String email, String password) {
        this.name     = name;
        this.lastName = lastName;
        this.email    = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
