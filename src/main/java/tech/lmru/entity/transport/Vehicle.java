package tech.lmru.entity.transport;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehicle_seq")
    @SequenceGenerator(
            name="vehicle_seq",
            sequenceName="vehicle_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name = "registration_number")
    private String registrationNumber;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "tonnage")
    private String tonnage;
    
    @Column(name = "capacity")
    private String capacity;
    
    @ManyToMany(mappedBy = "vehicles", fetch = FetchType.EAGER)
    private Set<Driver> drivers = new HashSet<>();


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the tonnage
	 */
	public String getTonnage() {
		return tonnage;
	}

	/**
	 * @param tonnage the tonnage to set
	 */
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the drivers
	 */
	public Set<Driver> getDrivers() {
		return drivers;
	}

	/**
	 * @param drivers the drivers to set
	 */
	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}
//
//	public TransportCompany getTransportCompany() {
//		return transportCompany;
//	}
//
//	public void setTransportCompany(TransportCompany transportCompany) {
//		this.transportCompany = transportCompany;
//	}
}