package view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        return sc.nextLine();
    }
}
