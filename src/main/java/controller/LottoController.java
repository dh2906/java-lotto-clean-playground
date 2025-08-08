package controller;

import model.LottoResultAnalyzer;
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
    private final LottoResultAnalyzer analyzer = new LottoResultAnalyzer();

    public void run() {
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(inputPurchaseAmount);
        InputValidator.validatePurchaseAmount(purchaseAmount);

        int count = purchaseAmount / 1000;
        lottoTicket.generateLottos(generator, count);

        outputView.printPurchaseCount(count);
        outputView.printLottoNumbers(lottoTicket);

        String inputWinningNumbers = inputView.inputWinningNumbers();
        String inputBonusNumber = inputView.inputBonusNumber();
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(inputWinningNumbers, inputBonusNumber);

        analyzer.analyze(lottoTicket, winningNumbers);
        outputView.printStatistics(analyzer.getResult(), analyzer.calculateProfitRate(purchaseAmount));
    }

}
