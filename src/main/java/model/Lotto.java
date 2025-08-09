package model;

import java.util.Collections;
import java.util.List;

import exception.CustomException;
import exception.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new CustomException(ErrorMessage.INVALID_NUMBERS_SIZE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
