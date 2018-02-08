package hu.preznyak.daos;

import hu.preznyak.entities.Service;

import java.util.List;

public interface ServiceDAO {
    Service getServiceById(int id);
    boolean removeService(int id);
    boolean updateService(Service service);
    List<Service> getAllServices();
}
