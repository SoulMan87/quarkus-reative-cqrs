package bankAccount.commands;

public record ChangeEmailCommand(String aggregateId, String newEmail) {
}
