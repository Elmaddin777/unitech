package az.unitech.app.client.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Currency {

    private String symbol;
    private Double rate;
}
