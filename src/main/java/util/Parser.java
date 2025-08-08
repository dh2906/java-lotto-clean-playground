package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.ErrorMessage;
import model.WinningNumbers;

public class Parser {

    public static int parsePurchaseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public static WinningNumbers parseWinningNumbers(String inputWinningNumbers, String inputBonusNumber) {
        try {
            List<Integer> numbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            int bonusNumber = Integer.parseInt(inputBonusNumber.trim());

            return new WinningNumbers(numbers, bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
