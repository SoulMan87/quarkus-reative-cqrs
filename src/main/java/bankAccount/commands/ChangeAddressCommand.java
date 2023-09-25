package bankAccount.commands;

public record ChangeAddressCommand(String aggregateId, String newAddress) {
}
