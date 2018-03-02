package hu.preznyak.entities;

import hu.preznyak.enums.ServiceType;

import javax.persistence.*;

/**
 * <h1>Service Entity Class</h1>
 * This is an entity class for services.
 *
 * @author Preznyák László
 * @version 1.0
 */

@Table
@Entity(name = "service")
public class Service {

    /**
     * The id of a service.
     * It is a generated value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Name of the service.
     * It's not nullable.
     */
    @Column(nullable = false)
    private String serviceName;

    /**
     * Type of the service.
     */
    @Column
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    /**
     * Description about the service.
     */
    @Column
    private String description;

    /**
     * Website link for the service.
     */
    @Column
    private String website;

    /**
     * The address of the service.
     */
    @Column(nullable = false)
    private String address;

    /**
     * No-arg constructor for service entity.
     */
    public Service() {
    }

    /**
     * Constructor for service entity with all variables.
     * @param serviceType Type of the service.
     * @param description Description about the service.
     * @param website Wwebsite of the service.
     * @param serviceName Name of the service.
     * @param address address of the service
     */
    public Service(ServiceType serviceType, String description, String website, String serviceName, String address) {
        this.serviceType = serviceType;
        this.description = description;
        this.website = website;
        this.serviceName = serviceName;
        this.address = address;
    }

    /**
     * Getter for id.
     * @return id of service.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id the id of the service.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for type of the service.
     * @return serviceType the type of the service.
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Setter for type of the service.
     * @param serviceType the type of the service.
     */
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Getter for description of the service.
     * @return description the description of the service.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     * @param description the description of the sercice.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for website.
     * @return website the website of the service.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Setter for website.
     * @param website the website of the service.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Getter for the name of the service.
     * @return serviceName the name of the service.
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Setter for the name of the service.
     * @param serviceName the name of the service.
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Getter method for the address of the service
     * @return address the address of the service
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for the address of the service.
     * @param address the address of the service.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ToString method of the Service class.
     * @return String format of a Service object.
     */
    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType=" + serviceType +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
