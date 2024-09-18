package spring.rest.js.rest.DAO;


import spring.rest.js.rest.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);
}
