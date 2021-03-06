package tech.lmru.entity.deliveryzone;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "DELIVERY_ZONE_COORDINATES")
public class DeliveryZoneCoordinate {

    public DeliveryZoneCoordinate() {
    }

    public DeliveryZoneCoordinate(BigDecimal lon, BigDecimal lat, int pos) {
        this.lon = lon;
        this.lat = lat;
        this.pos = pos;
    }

    public DeliveryZoneCoordinate(double lon, double lat, int pos) {
        this(new BigDecimal(lon), new BigDecimal(lat), pos);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_zone_coordinates_seq")
    @SequenceGenerator(
            name = "delivery_zone_coordinates_seq",
            sequenceName = "delivery_zone_coordinates_sequence",
            allocationSize = 1)
    private long id;

    @Column(name = "lat")
    private BigDecimal lat;

    @Column(name = "lon")
    private BigDecimal lon;

    @Column(name = "pos")
    private int pos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_zone_id")
    private DeliveryZone deliveryZone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public DeliveryZone getDeliveryZone() {
        return deliveryZone;
    }

    public void setDeliveryZone(DeliveryZone deliveryZone) {
        this.deliveryZone = deliveryZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryZoneCoordinate that = (DeliveryZoneCoordinate) o;
        return lat.equals(that.lat) &&
                lon.equals(that.lon) &&
                pos == that.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, lon, pos);
    }

    @Override
    public String toString() {
        return "DeliveryZoneCoordinate{" + "id=" + id + ", lat=" + lat + ", lon=" + lon + '}';
    }
}
