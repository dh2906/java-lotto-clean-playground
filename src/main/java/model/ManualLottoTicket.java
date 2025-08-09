package model;

import util.Parser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicket extends LottoTicket {

    public ManualLottoTicket(List<String> manualNumbersStrList) {
        super(generateManualLottos(manualNumbersStrList));
    }

    private static List<Lotto> generateManualLottos(List<String> manualNumbersStrList) {
        return manualNumbersStrList.stream()
            .map(Parser::parseManualLottoNumbers)
            .map(numbers -> numbers.stream()
                .map(LottoNumber::new)
                .toList())
            .map(Lotto::new)
            .toList();
    }
}
