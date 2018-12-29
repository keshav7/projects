package service.api;

import com.projects.core.datatypes.dto.ClientResponse;
import exception.FCException;
import request.OrderRequest;

public interface OrderMenuManagerService {
    ClientResponse createOrder(OrderRequest createOrderRequest, String requestedBy,
                               String requestId) throws FCException;


}
