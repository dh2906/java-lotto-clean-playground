package view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        return sc.nextLine();
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return sc.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");

        return sc.nextLine();
    }
}
