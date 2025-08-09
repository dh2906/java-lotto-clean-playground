package model;

import exception.CustomException;
import exception.ErrorMessage;

import javax.swing.undo.CannotUndoException;

public class LottoNumber {

    private int number;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        validateRange(number);

        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new CustomException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }
}
