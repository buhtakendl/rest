package spring.rest.js.rest.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import spring.rest.js.rest.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        User someUser = entityManager.find(User.class, id);
        entityManager.remove(someUser);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery("select u from User u where u.name =: name", User.class)
                .setParameter("name", name).getSingleResult();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
