package tech.lmru.entity.deliveryzone;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DELIVERY_ZONES")
public class DeliveryZone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "delivery_zones_seq")
    @SequenceGenerator(
            name="delivery_zones_seq",
            sequenceName="delivery_zones_sequence",
            allocationSize = 1)
    private long id;

    @OneToMany(mappedBy = "deliveryZone", cascade = CascadeType.ALL)
    private List<DeliveryZoneCoordinate> coordinateList;

}
