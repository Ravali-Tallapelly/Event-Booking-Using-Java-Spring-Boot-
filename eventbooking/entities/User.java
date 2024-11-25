// package com.mycompany.entities;

// public class User {
//     private Long id;
//     private String name;
//     private String email;

//     // Constructors
//     public User() {}
//     public User(Long id, String name, String email) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }
// }
package com.mycompany.eventbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;  // Add a username field
    private String name;
    private String email;
    private String password;

    // Default no-argument constructor required by JPA
    public User() {
    }

    // Constructor that accepts username, name, email, and password
    public User(String username, String name, String email, String password) {
        this.username = username;  // Set the username
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;  // Getter for username
    }

    public void setUsername(String username) {
        this.username = username;  // Setter for username
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
