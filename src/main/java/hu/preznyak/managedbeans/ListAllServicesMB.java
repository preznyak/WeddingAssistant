package hu.preznyak.managedbeans;

import hu.preznyak.daos.ServiceDAO;
import hu.preznyak.daos.impls.ServiceDAOImpl;
import hu.preznyak.entities.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "ServicesListMB")
@ViewScoped
public class ListAllServicesMB {

    private ServiceDAO serviceDAO = new ServiceDAOImpl();
    private List<Service> serviceList = serviceDAO.getAllServices();

    public ListAllServicesMB() {
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
