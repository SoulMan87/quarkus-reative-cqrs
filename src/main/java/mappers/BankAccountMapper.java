package mappers;

import bankAccount.domain.BankAccountAggregate;
import bankAccount.domain.BankAccountDocument;
import bankAccount.dto.BankAccountResponseDTO;

public class BankAccountMapper {
    public BankAccountMapper() {
    }

    public static BankAccountResponseDTO bankAccountResponseDTOFromAggregate(BankAccountAggregate bankAccountAggregate) {
        return new BankAccountResponseDTO (
                bankAccountAggregate.getId (),
                bankAccountAggregate.getEmail (),
                bankAccountAggregate.getAddress (),
                bankAccountAggregate.getUserName (),
                bankAccountAggregate.getBalance ()
        );
    }

    public static BankAccountResponseDTO bankAccountResponseDTOFromDocument(BankAccountDocument bankAccountDocument) {
        return new BankAccountResponseDTO (
                bankAccountDocument.getAggregateId (),
                bankAccountDocument.getEmail (),
                bankAccountDocument.getAddress (),
                bankAccountDocument.getUserName (),
                bankAccountDocument.getBalance ()
        );
    }

    public static BankAccountDocument bankAccountDocumentFromAggregate(BankAccountAggregate bankAccountAggregate) {
        return BankAccountDocument.builder ()
                .aggregateId (bankAccountAggregate.getId ())
                .email (bankAccountAggregate.getEmail ())
                .userName (bankAccountAggregate.getUserName ())
                .balance (bankAccountAggregate.getBalance ())
                .build ();
    }
}
