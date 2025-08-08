package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import util.LottoGenerator;
import util.Parser;

public class LottoTicket {

    private List<Lotto> lottos;

    public void generateAutoLottos(LottoGenerator generator, int count) {
        List<Lotto> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(generator.generate());
        }

        this.lottos = Collections.unmodifiableList(temp);
    }

    public void generateManualLottos(List<String> manualNumbersStrList) {
        List<Lotto> manualLottos = manualNumbersStrList.stream()
            .map(Parser::parseManualLottoNumbers)
            .map(Lotto::new)
            .toList();

        this.lottos = Collections.unmodifiableList(manualLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static LottoTicket merge(LottoTicket manual, LottoTicket auto) {
        List<Lotto> combined = new ArrayList<>();

        if (manual != null && manual.getLottos() != null) {
            combined.addAll(manual.getLottos());
        }

        if (auto != null && auto.getLottos() != null) {
            combined.addAll(auto.getLottos());
        }

        LottoTicket mergedTicket = new LottoTicket();
        mergedTicket.lottos = Collections.unmodifiableList(combined);

        return mergedTicket;
    }
}
