package model;

import java.util.Collections;
import java.util.List;

import exception.ErrorMessage;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateWinningNumbers(numbers);

        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNumbersSize(winningNumbers);
        validateNumbersDuplicate(winningNumbers);
        validateNumbersRange(winningNumbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_SIZE);
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE);
            }
        }
    }
}
