package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import enums.MenuType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItemRequest {
    @NotNull
    private String companyId;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private MenuType menuType;
}
