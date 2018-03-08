package hu.preznyak.services;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;
import hu.preznyak.entities.WeddingEvent;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public User getUserById(int id){
        return userDAO.getUserById(id);
    }

    public User getUser(String username, String password){
        return userDAO.getUser(username,password);
    }

    public boolean addUser(User user){
        return userDAO.addUser(user);
    }

    public boolean addServiceToUser(User user, Service service){
        return userDAO.addServiceToUser(user,service);
    }

    public boolean removeMyService(User user,int id){
        return userDAO.removeMyService(user,id);
    }

    public List<Service> getMyServices(User user){
        return userDAO.getMyServices(user);
    }

    public boolean addWeddingToUser(User user, WeddingEvent weddingEvent){
        return userDAO.addWeddingToUser(user,weddingEvent);
    }

    public boolean removeMyWedding(User user, int id){
        return userDAO.removeMyWedding(user,id);
    }

    public List<WeddingEvent> getMyWeddings(User user){
        return userDAO.getMyWeddings(user);
    }
}
