package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BorrowingDetail {
    private String orderId;
    private String itemCode;
    private Integer qty;
    private Double unitPrice;
}
