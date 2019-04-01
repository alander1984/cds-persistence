package tech.lmru.entity.route;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import tech.lmru.entity.plan.OptimizationTask;

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

    @OneToMany(mappedBy="delivery")
    @OrderBy("pos")
    public List<RoutePoint> routerPoints;
    
    @Column(name = "delivery_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime deliveryDate;
    
    @JoinColumn(name = "optimization_task_id", referencedColumnName = "id")
    @OneToOne(cascade={CascadeType.ALL})
    private OptimizationTask optimizationTask;
    
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne
    private Vehicle vehicle;

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
    
    
    
}
