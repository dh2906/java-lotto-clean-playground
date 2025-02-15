import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 생성 테스트")
public class LottoNumberProviderTest {
    private LottoNumberProvider lottoNumberProvider;

    @BeforeEach
    public void beforEach() {
        lottoNumberProvider = new LottoNumberProvider();
    }

    @DisplayName("6개의 번호가 생성되었는지 테스트")
    @Test
    public void testLottoHasSixNumbers() {
        var lottoNumber = lottoNumberProvider.getLottoNumber();

        assertThat(lottoNumber).hasSize(6);
    }

    @DisplayName("6개의 번호가 중복없이 생성되었는지 테스트")
    @Test
    public void testLottoHasSixUniqueNumbers() {
        var lottoNumber = lottoNumberProvider.getLottoNumber();
        var uniqueLottoNumber = lottoNumber.stream().distinct().collect(Collectors.toList());

        assertThat(uniqueLottoNumber).hasSize(6);
    }

    @DisplayName("생성된 로또 번호가 1~45의 범위에 맞는지 테스트")
    @Test
    public void testLottoNumbersRange() {
        var lottoNumber = lottoNumberProvider.getLottoNumber();

        assertThat(lottoNumber)
                .allMatch((num) -> num >= 1 && num <= 45);
    }
}
