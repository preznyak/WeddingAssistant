package hu.preznyak.daos;

import hu.preznyak.entities.User;

public interface UserDAO {
    User getUserById(int id);
    User getUser(String username, String password);
    User getUserByUsername(String username);
    boolean addUser(User user);
    boolean deleteUser(int id);
}
