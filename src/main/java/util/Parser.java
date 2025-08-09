package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.CustomException;
import exception.ErrorMessage;
import model.LottoNumber;
import model.WinningNumbers;

public class Parser {

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new CustomException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public static List<LottoNumber> parseManualLottoNumbers(String manualNumbersStr) {
        try {
            return Arrays.stream(manualNumbersStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
