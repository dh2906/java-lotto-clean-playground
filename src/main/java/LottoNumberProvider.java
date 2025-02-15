import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumberProvider {
    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumberList.add(i);
        }

        Collections.shuffle(lottoNumberList);

        lottoNumber = lottoNumberList.subList(0, 6);
        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}
