package view;

import model.Lotto;
import model.LottoTicket;

public class OutputView {

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다. \n", count);
    }

    public void printLottoNumbers(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto);
        }
    }
}
