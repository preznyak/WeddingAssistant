package hu.preznyak.entities;

import hu.preznyak.enums.ServiceType;

import javax.persistence.*;

@Table
@Entity(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String serviceName;

    @Column
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column
    private String website;

    public Service() {
    }

    public Service(ServiceType serviceType, String description, Address address, String website, String serviceName) {
        this.serviceType = serviceType;
        this.description = description;
        this.address = address;
        this.website = website;
        this.serviceName = serviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType=" + serviceType +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", website='" + website + '\'' +
                '}';
    }
}
