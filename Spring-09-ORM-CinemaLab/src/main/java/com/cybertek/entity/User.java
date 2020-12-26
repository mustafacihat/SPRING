package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
@NamedQueries({@NamedQuery(name = "User.getAllUsers", query = "select u from User u"), @NamedQuery(name = "User.getAllWithJPQL", query = "select u from User u")})
@NamedNativeQueries({@NamedNativeQuery(name = "User.retrieveUserWithName", query = "select * from user_account where username= ?1", resultClass = User.class),
        @NamedNativeQuery(name = "User.getAllUsersInAgeRange", query = "select * from user_account ua join account_details ad on ua.account_details_id = ad.id where age between ?1 and ?2", resultClass = User.class
        ),
        @NamedNativeQuery(name = "User.retrieveUserWithEmail", query = "select * from user_account where email = ?1", resultClass = User.class)})
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    private Account account;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
