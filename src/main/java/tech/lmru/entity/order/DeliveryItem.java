package tech.lmru.entity.order;

import java.math.BigDecimal;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "DELIVERY_ITEM")
public class DeliveryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "delivery_item_seq")
    @SequenceGenerator(
            name="delivery_item_seq",
            sequenceName="delivery_item_sequence",
            allocationSize = 1)
    private long id;
    
    @Column(name="product_lm_code")
    private String productLMCode;
    
    @Column(name="product_lm_name")
    private String productLMName;
    
    @Column(name="weight")
    private BigDecimal weight;
    
    @Column(name="volume")
    private BigDecimal volume;

    @Column(name="width")
    private BigDecimal width;

    @Column(name="length")
    private BigDecimal length;
    
    @Column(name="quantity")
    private BigDecimal quantity;
    
    @Column(name="loaded_quantity")
    private BigDecimal loadedQuantity;
    
    @Column(name="approved_quantity")
    private BigDecimal approvedQuantity;
    
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id",  referencedColumnName = "id")
    private Delivery delivery;    
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
	 * @return the productLMCode
	 */
	public String getProductLMCode() {
		return productLMCode;
	}

	/**
	 * @param productLMCode the productLMCode to set
	 */
	public void setProductLMCode(String productLMCode) {
		this.productLMCode = productLMCode;
	}

	/**
	 * @return the productLMName
	 */
	public String getProductLMName() {
		return productLMName;
	}

	/**
	 * @param productLMName the productLMName to set
	 */
	public void setProductLMName(String productLMName) {
		this.productLMName = productLMName;
	}

	/**
	 * @return the weight
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	/**
	 * @return the volume
	 */
	public BigDecimal getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	/**
	 * @return the width
	 */
	public BigDecimal getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public BigDecimal getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(BigDecimal length) {
		this.length = length;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the loadedQuantity
	 */
	public BigDecimal getLoadedQuantity() {
		return loadedQuantity;
	}

	/**
	 * @param loadedQuantity the loadedQuantity to set
	 */
	public void setLoadedQuantity(BigDecimal loadedQuantity) {
		this.loadedQuantity = loadedQuantity;
	}

	/**
	 * @return the approvedQuantity
	 */
	public BigDecimal getApprovedQuantity() {
		return approvedQuantity;
	}

	/**
	 * @param approvedQuantity the approvedQuantity to set
	 */
	public void setApprovedQuantity(BigDecimal approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
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
	 * @return the delivery
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
    
    
    
    
}
