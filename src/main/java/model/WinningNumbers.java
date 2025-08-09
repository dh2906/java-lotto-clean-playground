package model;

import java.util.Collections;
import java.util.List;

import exception.CustomException;
import exception.ErrorMessage;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validateWinningNumbers(numbers);
        validateBonusNumber(bonusNumber, numbers);

        this.numbers = Collections.unmodifiableList(numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumbersSize(winningNumbers);
        validateNumbersDuplicate(winningNumbers);
        validateNumbersRange(winningNumbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new CustomException(ErrorMessage.INVALID_NUMBERS_SIZE);
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new CustomException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new CustomException(ErrorMessage.INVALID_NUMBER_RANGE);
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new CustomException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
        if (numbers.contains(bonusNumber)) {
            throw new CustomException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
        }
    }
}
