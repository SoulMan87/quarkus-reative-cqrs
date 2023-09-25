package exceptions;

import static constans.Constans.EXECUTION_TIMEOUT_MESSAGE;

public class ExecutionTimeoutException extends RuntimeException {

    public ExecutionTimeoutException() {
        super (EXECUTION_TIMEOUT_MESSAGE);
    }

    public ExecutionTimeoutException(String message) {
        super (message);
    }
}
