package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Orders orders;

    @ManyToOne
    @MapsId("itemCode")
    @JoinColumn(name = "item_code")
    Item item;

    private int qty;
    private double unitPrice;
}
