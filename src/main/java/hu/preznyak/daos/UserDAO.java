package hu.preznyak.daos;

import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    User getUser(String username, String password);
    boolean addUser(User user);
    boolean addServiceToUser(User user, Service service);
    boolean removeMyService(User user,int id);
    List<Service> getMyServices(User user);
}
