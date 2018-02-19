package hu.preznyak.daos;

import hu.preznyak.entities.Service;
import hu.preznyak.entities.User;

import java.util.List;

public interface ServiceDAO {
    Service getServiceById(int id);
    boolean updateService(Service service);
    List<Service> getAllServices();
}
