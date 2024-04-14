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
@Table(name = "order_detail")
@IdClass(OrderDetailKey.class)
public class OrderDetail {
    @Id
    private String orderId;
    @Id
    private String itemCode;

    private int qty;
    private double unitPrice;
}
