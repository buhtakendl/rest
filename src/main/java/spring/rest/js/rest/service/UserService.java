package spring.rest.js.rest.service;


import spring.rest.js.rest.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}
