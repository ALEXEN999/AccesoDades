package com.company;

import java.io.Serializable;
import java.nio.file.attribute.UserPrincipal;

public class User implements Serializable {
    private static final long serialVersionUID = 128L;
    private String username, firstname,lastname, email,  password;
    private int iddepartamento;

    public User(String username, String firstname, String lastname, String email, String password, int iddepartamento) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.iddepartamento = iddepartamento;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getFirstname() {return firstname;}

    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", iddepartamento=" + iddepartamento +
                '}';
    }
}
