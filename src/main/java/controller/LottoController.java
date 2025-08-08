package controller;

import java.util.List;

import model.LottoTicket;
import model.WinningNumbers;
import util.LottoGenerator;
import util.Parser;
import util.RandomLottoGenerator;
import validation.InputValidator;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final LottoTicket lottoTicket = new LottoTicket();
    private final LottoGenerator generator = new RandomLottoGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(inputPurchaseAmount);
        InputValidator.validatePurchaseAmount(purchaseAmount);

        int count = purchaseAmount / 1000;
        lottoTicket.generateLottos(generator, count);

        outputView.printPurchaseCount(count);
        outputView.printLottoNumbers(lottoTicket);

        String inputWinningNumbers = inputView.inputWinningNumbers();
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(inputWinningNumbers);
    }

}
