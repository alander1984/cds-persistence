package tech.lmru.entity.deliveryzone;

import tech.lmru.entity.store.Store;
import tech.lmru.entity.transport.TransportCompany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DELIVERY_ZONES")
public class DeliveryZone {
    public DeliveryZone() {
    }

    public void addCoordinate(DeliveryZoneCoordinate coordinate){
        this.coordinateList.add(coordinate);
        coordinate.setDeliveryZone(this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_zones_seq")
    @SequenceGenerator(
            name = "delivery_zones_seq",
            sequenceName = "delivery_zones_sequence",
            allocationSize = 1)
    private long id;

    @OneToMany(mappedBy = "deliveryZone", cascade = CascadeType.ALL)
    private List<DeliveryZoneCoordinate> coordinateList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store ownStore;

    @ManyToOne
    @JoinColumn(name = "transport_company_id", referencedColumnName = "id")
    private TransportCompany ownTransportCompany;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DeliveryZoneCoordinate> getCoordinateList() {
        return coordinateList;
    }

    public Store getOwnStore() {
        return ownStore;
    }

    public void setOwnStore(Store ownStore) {
        this.ownStore = ownStore;
    }

    public TransportCompany getOwnTransportCompany() {
        return ownTransportCompany;
    }

    public void setOwnTransportCompany(TransportCompany ownTransportCompany) {
        this.ownTransportCompany = ownTransportCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryZone that = (DeliveryZone) o;
        return id == that.id &&
                Objects.equals(coordinateList, that.coordinateList) &&
                Objects.equals(ownStore, that.ownStore) &&
                Objects.equals(ownTransportCompany, that.ownTransportCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordinateList, ownStore, ownTransportCompany);
    }

    @Override
    public String toString() {
        return "DeliveryZone{" + "id=" + id + ", coordinateList=" + coordinateList + ", ownStore=" + ownStore + ", ownTransportCompany=" + ownTransportCompany + '}';
    }
}
