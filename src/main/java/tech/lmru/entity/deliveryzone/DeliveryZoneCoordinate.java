package tech.lmru.entity.deliveryzone;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DELIVERY_COORDINATES")
public class DeliveryZoneCoordinate {
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

    @ManyToOne
    @JoinColumn(name = "delivery_zone_id", referencedColumnName = "id")
    private DeliveryZone deliveryZone;
}
