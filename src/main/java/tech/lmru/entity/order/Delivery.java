package tech.lmru.entity.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @Column(name = "updated_date")
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
    
    @Column(name="comment")
    private String comment;
    
    @Column(name="city")
    private String city;
    
    @Column(name="street")
    private String street;
    
    @Column(name="house")
    private String house;
    
    @Column(name="entrance")
    private String entrance;
    
    @Column(name="flat")
    private String flat;
    
    @OneToMany(mappedBy="delivery")
    private Set<DeliveryItem> items = new HashSet<>();

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

    
    

}
