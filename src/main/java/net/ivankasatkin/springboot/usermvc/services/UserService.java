package net.ivankasatkin.springboot.usermvc.services;

import net.ivankasatkin.springboot.usermvc.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    User getUserById(int id);

    List<User> listUsers();
}
