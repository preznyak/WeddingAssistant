package hu.preznyak;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.daos.impls.UserDAOImpl;
import hu.preznyak.entities.User;

public class Main {
    public static void main(String[] args){
        UserDAO userDAO = new UserDAOImpl();
        User newUser = userDAO.getUser("preznyak","preznyakpw");
        System.out.println(newUser.getUsername());
    }
}
