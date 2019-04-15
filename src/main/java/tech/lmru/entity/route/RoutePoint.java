package tech.lmru.entity.route;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import tech.lmru.entity.order.Delivery;

@Entity
@Table(name = "ROUTE_POINT")
public class RoutePoint {
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "route_point_seq")
    @SequenceGenerator(
            name="route_point_seq",
            sequenceName="route_point_sequence",
            allocationSize = 1)
    private long id;
   
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    @OneToOne(cascade={CascadeType.ALL})
    private Delivery delivery;
    
    @JoinColumn(name = "route_id", referencedColumnName="id")
    @ManyToOne(cascade={CascadeType.ALL})
    private Route route;
    
    @Column(name = "arrival_time")
    private BigDecimal arrivalTime;

    @Column(name="pos")
    private int pos;

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

	/**
	 * @return the arrivalTime
	 */
	public BigDecimal getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(BigDecimal arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public void setRoute(Route route) {
	    this.route = route;
	}
	
	public Route getRoute() {
	    return route;
	}
	
	
    
    
   
}
