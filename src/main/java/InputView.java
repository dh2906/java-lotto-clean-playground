import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }


}
