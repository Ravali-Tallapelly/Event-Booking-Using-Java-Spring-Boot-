// package com.mycompany.eventbooking.controllers;

// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/eventbooking") // Base mapping for event booking-related endpoints
// public class EventBookingController {

//     // Mapping for the Home page
//     @GetMapping("/")
//     public String homePage() {
//         return "index";  // Returns home.html or the corresponding view
//     }

//     // Mapping for the Login page
//     @GetMapping("/login")
//     public String loginPage() {
//         return "login";  // Returns login.html or the corresponding view
//     }

//     // Mapping for the About page
//     @GetMapping("/about")
//     public String aboutPage() {
//         return "about";  // Returns about.html or the corresponding view
//     }

//     // Mapping for the Contact Us page
//     @GetMapping("/contact")
//     public String contactUsPage() {
//         return "contact";  // Returns contactus.html or the corresponding view
//     }

//     // Mapping for the Signup page
//     @GetMapping("/signup")
//     public String signupPage() {
//         return "signup";  // Returns signup.html or the corresponding view
//     }

//     // Mapping for the Services page
//     @GetMapping("/services")
//     public String servicesPage() {
//         return "services";  // Returns services.html or the corresponding view
//     }

//     // Mapping for the Dashboard page (Example)
//     @GetMapping("/dashboard")
//     public String dashboardPage() {
//         return "dashboard";  // Returns dashboard.html or the corresponding view
//     }

//     // Mapping for the Event Booking page
//     @GetMapping
//     public String eventBookingPage() {
//         return "eventbooking";  // Returns eventbooking.html or the corresponding view
//     }

//     // Additional mapping for other pages like FAQ or Privacy Policy if needed
//     @GetMapping("/faq")
//     public String faqPage() {
//         return "faq";  // Returns faq.html or the corresponding view
//     }

//     @GetMapping("/privacypolicy")
//     public String privacyPolicyPage() {
//         return "privacypolicy";  // Returns privacypolicy.html or the corresponding view
//     }

//     // POST mapping for event booking
//     @PostMapping("/book")
//     public ResponseEntity<String> bookEvent(@RequestBody EventBookingRequest request) {
//         // Example logic: Process the event booking request
//         System.out.println("Booking event: " + request.getEventName() + " for user: " + request.getUserName());

//         // Respond back with a success message
//         return ResponseEntity.ok("Event booking successful for " + request.getUserName());
//     }

//     // Class representing the request body
//     public static class EventBookingRequest {
//         private String eventName;
//         private String userName;

//         // Getters and Setters
//         public String getEventName() {
//             return eventName;
//         }

//         public void setEventName(String eventName) {
//             this.eventName = eventName;
//         }

//         public String getUserName() {
//             return userName;
//         }

//         public void setUserName(String userName) {
//             this.userName = userName;
//         }
//     }
// }
package com.mycompany.eventbooking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventBookingController {
    @GetMapping("/")
    public String homePage() {
        System.out.println("Resolving index.html...");
        return "index";  // Returns home.html or the corresponding view
    }
    // Mapping for the Signup page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";  // Returns signup.html from templates folder
    }
    // Handle signup form submission
    @PostMapping("/signup")
    public String handleSignup(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        // Process the signup data (e.g., save to database)
        // For now, we'll just redirect to the login page

        model.addAttribute("successMessage", "Signup successful! Please log in.");
        return "redirect:/login";
    }

    // Mapping for the Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Returns login.html from templates folder
    }
    @PostMapping("/login")
    public ModelAndView login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        
        // Mock authentication logic
        if ("ravali@gmail.com".equals(email) && "ravali".equals(password)) {
            // Redirect to dashboard or another page on successful login
            return new ModelAndView("redirect:/dashboard");
        }

        // Return to login page with error message if authentication fails
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "Invalid email or password. Please try again.");
        return modelAndView;
    }
    // Mapping for the Dashboard page
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // This will return dashboard.html
    }

    // Mapping for the About page
    @GetMapping("/about")
    public String aboutPage() {
        return "about";  // Returns about.html from templates folder
    }

    // Mapping for the Contact page
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";  // Returns contact.html from templates folder
    }

    @GetMapping("/registerevent")
    public String registerEventPage() {
        return "registerevent"; // Redirects to the register event page
    }

    @GetMapping("/upcomingevents")
    public String upcomingEventsPage() {
        return "upcomingevents"; // Redirects to the upcoming events page
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile"; // Redirects to the profile page
    }

    @GetMapping("/mybookings")
    public String myBookingsPage() {
        return "mybookings"; // Redirects to the my bookings page
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "redirect:/login"; // Redirects to the login page
    }
    
}
