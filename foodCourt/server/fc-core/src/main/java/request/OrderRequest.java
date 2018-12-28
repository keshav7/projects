package request;

import enums.OrderStatus;

import java.util.HashMap;
import java.util.List;

public class OrderRequest {

    String customerPhone;
    HashMap<Long, Integer> menuItemQty;
}