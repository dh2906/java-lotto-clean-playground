package model;

import java.util.Collections;
import java.util.List;

import exception.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_SIZE);
        }
    }
}
