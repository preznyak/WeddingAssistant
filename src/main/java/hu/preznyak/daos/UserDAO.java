package hu.preznyak.daos;

import hu.preznyak.entities.User;

public interface UserDAO {
    public User getUserById(int id);
    public User getUser(String username, String password);
    public boolean addUser(User user);
    public boolean deleteUser(int id);
}
