package com.mycompany.eventbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.eventbooking.entities.Event;
public interface EventRepository extends JpaRepository<Event, Long> {
    // Custom query methods (if needed) can be added here
}

