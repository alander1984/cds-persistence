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
    
    @OneToMany
    @JoinTable
    (
      name="transport_transport_company",
      joinColumns={ @JoinColumn(name="transport_company_id", referencedColumnName="id") },
      inverseJoinColumns={ @JoinColumn(name="transport_id", referencedColumnName="id") }
    )
    private Set<Transport> transports = new HashSet<>(); 

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
	 * @return the transports
	 */
	public Set<Transport> getTransports() {
		return transports;
	}

	/**
	 * @param transports the transports to set
	 */
	public void setTransports(Set<Transport> transports) {
		this.transports = transports;
	}
	
	
}