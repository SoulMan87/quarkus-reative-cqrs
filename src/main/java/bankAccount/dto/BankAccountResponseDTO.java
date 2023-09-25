package bankAccount.dto;

import java.math.BigDecimal;

public record BankAccountResponseDTO(
        String aggregateName,
        String email,
        String address,
        String userName,
        BigDecimal balance) {
}
