package tech.lmru.entity.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import tech.lmru.entity.store.Store;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import tech.lmru.entity.User;


@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "delivery_seq")
    @SequenceGenerator(
            name="delivery_seq",
            sequenceName="delivery_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name="lat")
    private BigDecimal lat;
    @Column(name="lon")
    private BigDecimal lon;

    @Column(name="time_window")
    private String timeWindow;
    
    @JoinColumn(name = "create_user_id", referencedColumnName = "id")
    @ManyToOne
    private User createUser;
    
    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss.SSS")
    private LocalDateTime createdDate;

    @JoinColumn(name = "update_user_id", referencedColumnName = "id")
    @ManyToOne
    private User lastUpdateUser;
    
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss.SSS")
    private LocalDateTime lastUpdateDate;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status;
    
    @Column(name = "delivery_date_min")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM")
    private LocalDateTime deliveryDateMin;
    
    @Column(name = "delivery_date_max")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM")
    private LocalDateTime deliveryDateMax;
    
    @Column(name="fullname")
    private String fullName;
    
    @Column(name="comment")
    private String comment;
    
    @Column(name="external")
    private String external;
    
    @Column(name="city")
    private String city;
    
    @Column(name="zone")
    private String zone;
    
    @Column(name="metro_station")
    private String metroStation;
    
    @Column(name="street")
    private String street;
    
    @Column(name="house")
    private String house;
    
    @Column(name="entrance")
    private String entrance;
    
    @Column(name="floor")
    private String floor;
    
    @Column(name="flat")
    private String flat;
    
    @Column(name="company_description")
    private String company;
    
    @Column(name="consignee")
    private String consignee;
    
    @Column(name="phone_primary")
    private String phone;
    
    @Column(name="phone_secondary")
    private String phoneSecondary;
    
    @Column(name="email")
    private String email;
    
    @Column(name="unloadtype")
    private String unloadType;
    
    @Column(name="paper")
    private String paper;
    
    @Column(name="payment_status")
    private String paymentStatus;
    
    
    @OneToMany(mappedBy="delivery", fetch = FetchType.EAGER)
    private Set<DeliveryItem> items = new HashSet<>();

    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne
    private Store store;


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
	 * @return the timeWindow
	 */
	public String getTimeWindow() {
		return timeWindow;
	}

	/**
	 * @param timeWindow the timeWindow to set
	 */
	public void setTimeWindow(String timeWindow) {
		this.timeWindow = timeWindow;
	}

	/**
	 * @return the createUser
	 */
	public User getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdateUser
	 */
	public User getLastUpdateUser() {
		return lastUpdateUser;
	}

	/**
	 * @param lastUpdateUser the lastUpdateUser to set
	 */
	public void setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the status
	 */
	public DeliveryStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(DeliveryStatusEnum status) {
		this.status = status;
	}

	/**
	 * @return the deliveryDateMin
	 */
	public LocalDateTime getDeliveryDateMin() {
		return deliveryDateMin;
	}

	/**
	 * @param deliveryDateMin the deliveryDateMin to set
	 */
	public void setDeliveryDateMin(LocalDateTime deliveryDateMin) {
		this.deliveryDateMin = deliveryDateMin;
	}

	/**
	 * @return the deliveryDateMax
	 */
	public LocalDateTime getDeliveryDateMax() {
		return deliveryDateMax;
	}

	/**
	 * @param deliveryDateMax the deliveryDateMax to set
	 */
	public void setDeliveryDateMax(LocalDateTime deliveryDateMax) {
		this.deliveryDateMax = deliveryDateMax;
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

	/**
	 * @return the items
	 */
	public Set<DeliveryItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<DeliveryItem> items) {
		this.items = items;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the entrance
	 */
	public String getEntrance() {
		return entrance;
	}

	/**
	 * @param entrance the entrance to set
	 */
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	/**
	 * @return the flat
	 */
	public String getFlat() {
		return flat;
	}

	/**
	 * @param flat the flat to set
	 */
	public void setFlat(String flat) {
		this.flat = flat;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

    /**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * @return the external
	 */
	public String getExternal() {
		return external;
	}

	/**
	 * @param external the external to set
	 */
	public void setExternal(String external) {
		this.external = external;
	}
	
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	/**
	 * @return the metroStation
	 */
	public String getMetroStation() {
		return metroStation;
	}

	/**
	 * @param metroStation the metroStation to set
	 */
	public void setMetroStation(String metroStation) {
		this.metroStation = metroStation;
	}
	
	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the phoneSecondary
	 */
	public String getPhoneSecondary() {
		return phoneSecondary;
	}

	/**
	 * @param phoneSecondary the phoneSecondary to set
	 */
	public void setPhoneSecondary(String phoneSecondary) {
		this.phoneSecondary = phoneSecondary;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the unloadType
	 */
	public String getUnloadType() {
		return unloadType;
	}

	/**
	 * @param unloadType the unloadType to set
	 */
	public void setUnloadType(String unloadType) {
		this.unloadType = unloadType;
	}
	
	/**
	 * @return the paper
	 */
	public String getPaper() {
		return paper;
	}

	/**
	 * @param paper the paper to set
	 */
	public void setPaper(String paper) {
		this.paper = paper;
	}
	
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}

	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	
    

}
