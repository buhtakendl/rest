package spring.rest.js.rest.DAO;


import spring.rest.js.rest.model.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByName(String username);

    User getUserById(long id);
}
