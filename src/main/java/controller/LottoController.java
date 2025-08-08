package controller;

import java.util.List;

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

    private final LottoGenerator generator = new RandomLottoGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoResultAnalyzer analyzer = new LottoResultAnalyzer();

    public void run() {
        LottoTicket manualTicket = new LottoTicket();
        LottoTicket autoTicket = new LottoTicket();
        LottoTicket lottoTicket = new LottoTicket();

        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        int purchaseAmount = Parser.parseInt(inputPurchaseAmount);
        InputValidator.validatePurchaseAmount(purchaseAmount);

        int totalCount = purchaseAmount / 1000;

        String inputManualCount = inputView.inputManualLottoCount();
        int manualCount = Parser.parseInt(inputManualCount);
        InputValidator.validateManualCount(manualCount, totalCount);

        List<String> inputManualNumbers = inputView.inputManualLottoNumbers(manualCount);
        manualTicket.generateManualLottos(inputManualNumbers);

        int autoCount = totalCount - manualCount;
        autoTicket.generateAutoLottos(generator, autoCount);

        lottoTicket = LottoTicket.merge(manualTicket, autoTicket);

        outputView.printPurchaseCount(manualCount, autoCount);
        outputView.printLottoNumbers(lottoTicket);

        String inputWinningNumbers = inputView.inputWinningNumbers();
        String inputBonusNumber = inputView.inputBonusNumber();
        WinningNumbers winningNumbers = Parser.parseWinningNumbers(inputWinningNumbers, inputBonusNumber);

        analyzer.analyze(lottoTicket, winningNumbers);
        outputView.printStatistics(analyzer.getResult(), analyzer.calculateProfitRate(purchaseAmount));
    }
}
