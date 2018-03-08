package hu.preznyak.services;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.entities.Service;
import hu.preznyak.enums.ServiceType;

import java.util.List;

public class ServiceService {

    private ServiceDAO serviceDAO = new ServiceDAOImpl();

    public Service getServiceById(int id){
        return serviceDAO.getServiceById(id);
    }

    public List<Service> getAllServices(){
        return serviceDAO.getAllServices();
    }

    public boolean updateService(Service service){
        return serviceDAO.updateService(service);
    }

    public List<Service> getServicesByServiceTypes(List<ServiceType> serviceTypes){
        return serviceDAO.getServicesByServiceTypes(serviceTypes);
    }
}
