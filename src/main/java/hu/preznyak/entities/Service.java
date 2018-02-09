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

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Column
    private String website;

    public Service() {
    }

    public Service(User user, ServiceType serviceType, String description, Address address, String website) {
        this.user = user;
        this.serviceType = serviceType;
        this.description = description;
        this.address = address;
        this.website = website;
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

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", website='" + website + '\'' +
                '}';
    }
}
