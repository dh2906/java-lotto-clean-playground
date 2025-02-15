import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumberProvider {
    List<Integer> lottoNumberList = new ArrayList<>();

    public LottoNumberProvider() {
        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(i);
        }
    }

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber;

        Collections.shuffle(lottoNumberList);

        lottoNumber = lottoNumberList.subList(0, 6);
        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}
