package hu.preznyak.daos;

import hu.preznyak.entities.Request;

import java.util.List;

public interface RequestDao {

    boolean createRequest(Request request);
    boolean deleteRequest(Request request);
    List<Request> getAllRequests();
}
