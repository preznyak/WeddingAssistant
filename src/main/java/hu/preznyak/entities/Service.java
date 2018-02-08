package hu.preznyak.entities;

import hu.preznyak.enums.ServiceType;

import javax.persistence.*;

@Table
@Entity(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column
    private String description;

    public Service() {
    }

    public Service(User user, ServiceType serviceType, String description) {
        this.user = user;
        this.serviceType = serviceType;
        this.description = description;
    }

    public Service(ServiceType serviceType, String description) {
        this.serviceType = serviceType;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", description='" + description + '\'' +
                '}';
    }
}
