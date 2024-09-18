package spring.rest.js.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.js.rest.model.User;
import spring.rest.js.rest.service.RoleService;
import spring.rest.js.rest.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById (@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
//        getUserRoles(user);
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users/{id}")
    public User updateUser (@PathVariable("id") long id, @RequestBody User user) {
//        getUserRoles(user);
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "User was deleted";
    }
}
