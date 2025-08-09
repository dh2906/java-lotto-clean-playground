package model;

import exception.CustomException;
import exception.ErrorMessage;

public class PurchaseAmount {

    private final int amount;

    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(String inputAmount) {
        this.amount = validate(inputAmount);
    }

    public int getAmount() {
        return amount;
    }

    private int validate(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException ex) {
            throw new CustomException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public int getTotalLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
