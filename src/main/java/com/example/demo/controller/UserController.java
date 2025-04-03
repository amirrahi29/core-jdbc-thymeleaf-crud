
// thymeleaf mvc

//package com.example.demo.controller;
//import com.example.demo.model.User;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//        model.addAttribute("listUsers", userService.getAllUsers());
//        model.addAttribute("user", new User());
//        model.addAttribute("pageTitle", "User List");
//        return "index";
//    }
//
//    @GetMapping("/add")
//    public String showAddUserForm(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("pageTitle", "Add User");
//        return "add"; // This must match templates/add.html
//    }
//
//    @PostMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/editUser/{id}")
//    public String editUser(@PathVariable int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        model.addAttribute("pageTitle", "Edit User");
//        return "edit";
//    }
//
//    @PostMapping("/updateUser")
//    public String updateUser(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
//}


//rest api's

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // API base path
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User created successfully";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id); // Ensure correct ID
        userService.updateUser(user);
        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
