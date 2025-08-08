package validation;

import exception.ErrorMessage;

public class InputValidator {

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_VALUE);
        }
    }

    public static void validateManualCount(int manualCount, int totalCount) {
        validateManualCountNotNegative(manualCount);
        validateManualCountNotExceedTotal(manualCount, totalCount);
    }

    private static void validateManualCountNotNegative(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MANUAL_COUNT_NEGATIVE);
        }
    }

    private static void validateManualCountNotExceedTotal(int manualCount, int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MANUAL_COUNT_EXCEED);
        }
    }
}
