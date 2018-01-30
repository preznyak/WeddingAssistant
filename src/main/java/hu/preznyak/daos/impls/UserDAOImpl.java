package hu.preznyak.daos.impls;

import hu.preznyak.daos.UserDAO;
import hu.preznyak.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class UserDAOImpl implements UserDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("wunit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public User getUserById(int id) {
        return null;
    }

        @Override
        public User getUser(String username, String password) {
            try {
                User user = (User) em
                        .createQuery("SELECT u FROM wa_user u WHERE u.username = :name and u.password = :pw")
                        .setParameter("name", username)
                        .setParameter("pw", password)
                        .getSingleResult();

                return user;
            } catch (NoResultException e){
                e.printStackTrace();
                return null;
            }

        }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

}
