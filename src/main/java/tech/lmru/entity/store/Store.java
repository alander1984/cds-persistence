package tech.lmru.entity.store;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "STORE")
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "store_seq")
    @SequenceGenerator(
            name="store_seq",
            sequenceName="store_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private StoreTypeEnum type;
    
    @Column(name="store_name")
    private String name;
    
    @Column(name="address")
    private String address;
    
    @Column(name="code")
    private String code; 
    
    @Column(name="lon")
    private BigDecimal lon;
    
    @Column(name="lat")
    private BigDecimal lat;
    
    @Column(name="comment")
    private String comment;
    
    
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
	 * @return the type
	 */
	public StoreTypeEnum getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(StoreTypeEnum type) {
		this.type = type;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the lon
	 */
	public BigDecimal getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	/**
	 * @return the lat
	 */
	public BigDecimal getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
    
    
    
}