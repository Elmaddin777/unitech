package az.unitech.app.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountDto {

    private String accountNo;
    private BigDecimal balance;

}
