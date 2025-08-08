package view;

import java.text.DecimalFormat;
import java.util.Map;

import model.Lotto;
import model.LottoTicket;
import model.Rank;

public class OutputView {

    private static final DecimalFormat df = new DecimalFormat("0.##");

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다. \n", count);
    }

    public void printLottoNumbers(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void printStatistics(Map<Rank, Integer> result, double profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);

            System.out.printf("%d개 일치 (%s원)- %d개%n",
                rank.getMatchCount(),
                String.format("%,d", rank.getPrize()),
                count);
        }

        System.out.printf("총 수익률은 %s입니다. %n", df.format(profitRate));
    }
}
