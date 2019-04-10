package tech.lmru.entity.plan;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import tech.lmru.entity.User;
import tech.lmru.entity.order.Delivery;
import tech.lmru.entity.route.Route;
import tech.lmru.entity.transport.Vehicle;

@Entity
@Table(name = "OPTIMIZATION_TASK")
public class OptimizationTask {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "optimization_task_seq")
    @SequenceGenerator(
            name="optimization_task_seq",
            sequenceName="optimization_task_sequence",
            allocationSize = 1)
    private long id;
    
        
    @Column(name = "create_datetime")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss.SSS")
    private LocalDateTime createDateTime;
    
    @Column(name = "start_datetime")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss.SSS")
    private LocalDateTime startDateTime;
    
    @Column(name = "complete_datetime")
    @JsonFormat(pattern = "yyyy-mm-dd HH:MM:ss.SSS")
    private LocalDateTime completeDateTime;
    
    @JoinColumn(name = "create_user_id", referencedColumnName = "id")
    @ManyToOne
    private User createUser;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OptimizationTaskStatusEnum status;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_delivery", joinColumns = {
            @JoinColumn(name = "task_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "delivery_id",
                    nullable = false, updatable = false) })
    private Set<Delivery> deliveries = new HashSet<Delivery>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_vehicle", joinColumns = {
            @JoinColumn(name = "task_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "vehicle_id",
                    nullable = false, updatable = false) })
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();
    
    @OneToMany(mappedBy="optimizationTask")
    private Set<Route> items = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getCompleteDateTime() {
        return completeDateTime;
    }

    public void setCompleteDateTime(LocalDateTime completeDateTime) {
        this.completeDateTime = completeDateTime;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public OptimizationTaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OptimizationTaskStatusEnum status) {
        this.status = status;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Route> getItems() {
        return items;
    }

    public void setItems(Set<Route> items) {
        this.items = items;
    }
}
