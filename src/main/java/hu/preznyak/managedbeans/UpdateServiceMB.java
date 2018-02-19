package hu.preznyak.managedbeans;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.entities.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UpdateServiceMB")
@SessionScoped
public class UpdateServiceMB {

    private Service updateableService;

    public String selectServiceForUpdate(Service service){
        updateableService = service;
        return "/updateMyService";
    }

    public void updateService(){
        ServiceDAO serviceDAO = new ServiceDAOImpl();
        serviceDAO.updateService(updateableService);
    }

    public UpdateServiceMB() {
    }

    public Service getUpdateableService() {
        return updateableService;
    }

    public void setUpdateableService(Service updateableService) {
        this.updateableService = updateableService;
    }
}
