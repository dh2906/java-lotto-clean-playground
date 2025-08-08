package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.LottoGenerator;

public class LottoTicket {

    private List<Lotto> lottos;

    public void generateLottos(LottoGenerator generator, int count) {
        List<Lotto> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(generator.generate());
        }

        this.lottos = Collections.unmodifiableList(temp);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
