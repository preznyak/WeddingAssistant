package hu.preznyak.services;

import hu.preznyak.daos.RequestDao;
import hu.preznyak.daos.impls.RequestDaoImpl;
import hu.preznyak.entities.Request;
import hu.preznyak.entities.Service;

import java.util.ArrayList;
import java.util.List;

public class RequestService {

    private RequestDao requestDao = new RequestDaoImpl();

    public boolean createRequest(Request request){
        request.setActive(true);
        return requestDao.createRequest(request);
    }

    public boolean deleteRequest(Request request){
        return requestDao.deleteRequest(request);
    }

    public List<Request> getAllRequests(){
        return requestDao.getAllRequests();
    }

    public List<Request> getMyRequests(List<Service> myServices){
        List<Request> allRequests = getAllRequests();
        List<Request> myRequests = new ArrayList<>();
        for(Service service : myServices){
            myRequests.addAll(requestDao.getRequestsByService(service));
        }
        return myRequests;
    }

    public boolean updateRequest(Request request) { return requestDao.updateRequest(request);}
}
