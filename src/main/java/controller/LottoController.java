package controller;

import java.util.List;

import model.*;
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

    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int manualCount = getManualCount(purchaseAmount);
        int autoCount = (purchaseAmount / LOTTO_PRICE) - manualCount;

        LottoTicket lottoTicket = generateTickets(manualCount, autoCount);
        printTickets(lottoTicket, manualCount, autoCount);
        analyzeResult(lottoTicket, purchaseAmount);
    }

    private int getPurchaseAmount() {
        String input = inputView.inputPurchaseAmount();
        int amount = Parser.parseInt(input);

        InputValidator.validatePurchaseAmount(amount);

        return amount;
    }

    private int getManualCount(int purchaseAmount) {
        String input = inputView.inputManualLottoCount();
        int manualCount = Parser.parseInt(input);

        InputValidator.validateManualCount(manualCount, purchaseAmount / 1000);

        return manualCount;
    }

    private LottoTicket generateTickets(int manualCount, int autoCount) {
        List<String> manualInputs = inputView.inputManualLottoNumbers(manualCount);

        ManualLottoTicket manualTicket = new ManualLottoTicket(manualInputs);
        AutoLottoTicket autoTicket = new AutoLottoTicket(generator, autoCount);

        return LottoTicket.merge(manualTicket, autoTicket);
    }

    private void printTickets(LottoTicket lottoTicket, int manualCount, int autoCount) {
        outputView.printPurchaseCount(manualCount, autoCount);
        outputView.printLottoNumbers(lottoTicket);
    }

    private void analyzeResult(LottoTicket lottoTicket, int purchaseAmount) {
        String winningNums = inputView.inputWinningNumbers();
        String bonusNum = inputView.inputBonusNumber();

        WinningNumbers winningNumbers = Parser.parseWinningNumbers(winningNums, bonusNum);

        analyzer.analyze(lottoTicket, winningNumbers);
        outputView.printStatistics(analyzer.getResult(), analyzer.calculateProfitRate(purchaseAmount));
    }
}
