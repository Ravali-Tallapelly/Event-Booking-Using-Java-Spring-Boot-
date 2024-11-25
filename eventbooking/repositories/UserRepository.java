package com.mycompany.eventbooking.repositories;

import com.mycompany.eventbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a user by username
    User findByUsername(String username);

    // Save the user with an encoded password - This is a default method
    default User saveUserWithEncodedPassword(User user, String encodedPassword) {
        // Set the encoded password manually since no PasswordEncoder is available
        user.setPassword(encodedPassword);
        return save(user); // `save` is a method inherited from JpaRepository
    }
}
