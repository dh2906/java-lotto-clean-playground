package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private final List<Integer> numberList = new ArrayList<>();

    public RandomLottoGenerator() {
        for (int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(numberList);

        List<Integer> numList = numberList.subList(0, 6);

        Collections.sort(numList);

        return numList;
    }
}
