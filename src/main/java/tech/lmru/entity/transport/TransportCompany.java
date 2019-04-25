package tech.lmru.entity.transport;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TRANSPORT_COMPANY")
public class TransportCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transport_company_seq")
    @SequenceGenerator(
            name="transport_company_seq",
            sequenceName="transport_company_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable
    //(
    //  name="vehicle_transport_company",
    //  joinColumns=(@JoinColumn(name="transport_company_id", referencedColumnName="id")),
    //  inverseJoinColumns=(@JoinColumn(name="vehicle_id", referencedColumnName="id"))
   // )
    @JoinTable(name = "VEHICLE_TRANSPORT_COMPANY",
        joinColumns = @JoinColumn(name = "transport_company_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "id"))
    private Set<Vehicle> vehicles = new HashSet<>();

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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the vehicles
	 */
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}