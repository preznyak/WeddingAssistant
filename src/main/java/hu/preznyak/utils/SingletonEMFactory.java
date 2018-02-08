package hu.preznyak.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEMFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("waunit");

    public SingletonEMFactory() {
    }

    public static EntityManagerFactory getFactory(){
        return emf;
    }
}
