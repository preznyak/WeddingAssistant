package hu.preznyak.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <h1>SingletonEntityManagerFactory class</h1>
 * This is a class for creating a single entity manager object.
 *
 * @author Preznyák László
 * @version 1.0
 */

public class SingletonEMFactory {

    /**
     * This is a static EntityManagerFactory object.
     */
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("waunit");

    /**
     * This is a no-arg constructor of the class.
     */
    public SingletonEMFactory() {
    }

    /**
     * This static method is a getter method.
     * By this method the entity manager factory could be used.
     * @return emf The entity manager factory.
     */
    public static EntityManagerFactory getFactory(){
        return emf;
    }
}
