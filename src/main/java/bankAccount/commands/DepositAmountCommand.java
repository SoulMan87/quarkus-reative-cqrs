package bankAccount.commands;

import java.math.BigDecimal;

public record DepositAmountCommand(String aggregateId, BigDecimal amount) {
}
