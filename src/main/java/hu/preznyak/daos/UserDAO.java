package hu.preznyak.daos;

import hu.preznyak.entities.User;

public interface UserDAO {
    User getUserById(int id);
    User getUser(String username, String password);
    boolean addUser(User user);
    boolean deleteUser(int id);
}
