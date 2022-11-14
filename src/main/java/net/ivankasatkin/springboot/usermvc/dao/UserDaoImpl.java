package net.ivankasatkin.springboot.usermvc.dao;

import net.ivankasatkin.springboot.usermvc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User newUser) {
        User userToUpdate = getUserById(id);
        userToUpdate.setName(newUser.getName());
        userToUpdate.setSurname(newUser.getSurname());
        userToUpdate.setAge(newUser.getAge());
        entityManager.merge(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id = " + id).executeUpdate();
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = " + id, User.class);
        return query.getSingleResult();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
