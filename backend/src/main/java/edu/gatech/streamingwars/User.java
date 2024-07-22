package edu.gatech.streamingwars;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.Boolean;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private Boolean admin;

    public User() {}

    public User(String email, String password, String isAdmin) {
        this.email = email;
        this.password = password;
        this.admin = Boolean.valueOf(isAdmin);
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "{" +
                "email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}
