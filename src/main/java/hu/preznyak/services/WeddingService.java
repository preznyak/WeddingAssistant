package hu.preznyak.services;

import hu.preznyak.daos.WeddingDao;
import hu.preznyak.daos.impls.WeddingDaoImpl;
import hu.preznyak.entities.WeddingEvent;

import java.util.List;

public class WeddingService {

    private WeddingDao weddingDao =  new WeddingDaoImpl();

    public WeddingEvent getWeddingEventById(int id){
        return weddingDao.getWeddingEventById(id);
    }

    public List<WeddingEvent> getAllWeddingEvents(){
        return weddingDao.getAllWeddingEvents();
    }

    public boolean updateWedding(WeddingEvent weddingEvent){
        return weddingDao.updateWedding(weddingEvent);
    }
}
