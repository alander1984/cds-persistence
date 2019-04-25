package tech.lmru.entity.route;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import tech.lmru.entity.plan.OptimizationTask;
import tech.lmru.entity.store.Store;
import tech.lmru.entity.transport.Driver;
import tech.lmru.entity.transport.TransportCompany;
import tech.lmru.entity.transport.Vehicle;

@Entity
@Table(name="ROUTES")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "route_seq")
    @SequenceGenerator(
            name="route_seq",
            sequenceName="route_sequence",
            allocationSize = 1)
    private long id;

	  @Column(name="route_name")
	  private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.MERGE})
    @JoinColumn(name = "route_id")
    @OrderBy("pos")
    public List<RoutePoint> routerPoints;

    @Column(name = "delivery_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime deliveryDate;

    @JoinColumn(name = "optimization_task_id", referencedColumnName = "id")
    @OneToOne(cascade={CascadeType.ALL})
    private OptimizationTask optimizationTask;

    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", updatable = false)
    @ManyToOne(cascade={CascadeType.MERGE})
    private Vehicle vehicle;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "transport_company_id", referencedColumnName = "id", updatable = false)
    private TransportCompany transportCompany;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "store_id", referencedColumnName = "id", updatable = false)
    private Store store;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "driver_id", referencedColumnName = "id", updatable = false)
    private Driver driver;

    @OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.MERGE})
    @JoinColumn(name = "route_id")
    @OrderBy("timestamp")
    public List<RouteTrack> routeTracks;

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
	 * @return the routerPoints
	 */
	public List<RoutePoint> getRouterPoints() {
		return routerPoints;
	}

	/**
	 * @param routerPoints the routerPoints to set
	 */
	public void setRouterPoints(List<RoutePoint> routerPoints) {
		this.routerPoints = routerPoints;
	}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDateTime deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public OptimizationTask getOptimizationTask() {
    return optimizationTask;
  }

  public void setOptimizationTask(OptimizationTask optimizationTask) {
    this.optimizationTask = optimizationTask;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public TransportCompany getTransportCompany() {
    return transportCompany;
  }

  public void setTransportCompany(TransportCompany transportCompany) {
    this.transportCompany = transportCompany;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }


  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

    /**
     * @return the routeTracks
     */
    public List<RouteTrack> getRouteTracks() {
    	return routeTracks;
    }
    
    /**
     * @param routeTracks the routeTracks to set
     */
    public void setRouteTracks(List<RouteTrack> routeTracks) {
    	this.routeTracks = routeTracks;
    }
}
