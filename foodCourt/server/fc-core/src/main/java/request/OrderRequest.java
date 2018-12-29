package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import enums.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    @NotNull
    String customerPhone;
    @NotNull
    HashMap<String, Integer> menuItemQty;
}