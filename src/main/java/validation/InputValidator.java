package validation;

import java.util.List;

import exception.ErrorMessage;

public class InputValidator {

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_VALUE);
        }
    }


}
