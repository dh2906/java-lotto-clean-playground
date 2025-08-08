package controller;

import exception.ErrorMessage;
import model.LottoTicket;
import util.LottoGenerator;
import util.RandomLottoGenerator;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final LottoTicket lottoTicket = new LottoTicket();
    private final LottoGenerator generator = new RandomLottoGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String inputAmount = inputView.inputPurchaseAmount();
        int amount = parsePurchaseAmount(inputAmount);
        validatePurchaseAmount(amount);

        int count = amount / 1000;
        lottoTicket.generateLottos(generator, count);

        outputView.printPurchaseCount(count);
        outputView.printLottoNumbers(lottoTicket);
    }

    private int parsePurchaseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_VALUE);
        }
    }
}
