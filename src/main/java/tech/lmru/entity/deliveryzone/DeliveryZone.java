package tech.lmru.entity.deliveryzone;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DELIVERY_ZONES")
public class DeliveryZone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_zones_seq")
    @SequenceGenerator(
            name = "delivery_zones_seq",
            sequenceName = "delivery_zones_sequence",
            allocationSize = 1)
    private long id;

    @OneToMany(mappedBy = "deliveryZone", cascade = CascadeType.ALL)
    private List<DeliveryZoneCoordinate> coordinateList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DeliveryZoneCoordinate> getCoordinateList() {
        return coordinateList;
    }

//    public void setCoordinateList(List<DeliveryZoneCoordinate> coordinateList) {
//        this.coordinateList = coordinateList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryZone that = (DeliveryZone) o;
        return id == that.id &&
                Objects.equals(coordinateList, that.coordinateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordinateList);
    }

    @Override
    public String toString() {
        return "DeliveryZone{id=" + id + ", coordinateList=" + coordinateList
                + '}';
    }
}
