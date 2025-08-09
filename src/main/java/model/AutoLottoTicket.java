package model;

import util.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoTicket extends LottoTicket {

    public AutoLottoTicket(LottoGenerator generator, int count) {
        super(generateAutoLottos(generator, count));
    }

    private static List<Lotto> generateAutoLottos(LottoGenerator generator, int count) {
        List<Lotto> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(generator.generate());
        }

        return Collections.unmodifiableList(temp);
    }
}
