package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDetailKey implements Serializable {
    private String orderId;
    private String itemCode;
}
