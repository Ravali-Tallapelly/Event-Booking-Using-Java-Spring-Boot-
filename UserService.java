package com.mycompany.eventbooking.services;

import com.mycompany.eventbooking.entities.User;
import com.mycompany.eventbooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public Long generateId() {
        // Query the SQLite database to get the latest ID and increment manually
        Query query = entityManager.createNativeQuery("SELECT MAX(id) FROM your_table");
        Long maxId = (Long) query.getSingleResult();
        return (maxId != null ? maxId : 0) + 1;
    }
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Save a new user with the plain password (no encoding)
    public User saveUser(User user) {
        return userRepository.save(user); // Save user directly without encoding the password
    }

    // Find user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
