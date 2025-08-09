import model.AutoCount;
import model.AutoLottoTicket;
import model.Lotto;
import model.LottoNumber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.LottoGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketTest {

    @Test
    void 지정된_개수만큼_로또가_자동으로_생성된다() {
        TestLottoGenerator generator = new TestLottoGenerator();
        AutoCount count = new AutoCount(3);

        AutoLottoTicket ticket = new AutoLottoTicket(generator, count);

        assertThat(ticket.getLottos()).hasSize(3);
    }

    @Nested
    public class TestLottoGenerator implements LottoGenerator {

        public TestLottoGenerator() { }

        @Override
        public Lotto generate() {
            return new Lotto(
                List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
                )
            );
        }
    }
}
