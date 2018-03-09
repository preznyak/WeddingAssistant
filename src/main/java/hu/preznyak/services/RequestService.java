package hu.preznyak.services;

import hu.preznyak.daos.RequestDao;
import hu.preznyak.daos.impls.RequestDaoImpl;
import hu.preznyak.entities.Request;

import java.util.List;

public class RequestService {

    private RequestDao requestDao = new RequestDaoImpl();

    public boolean createRequest(Request request){
        return requestDao.createRequest(request);
    }

    public boolean deleteRequest(Request request){
        return requestDao.deleteRequest(request);
    }

    public List<Request> getAllRequests(){
        return requestDao.getAllRequests();
    }
}
