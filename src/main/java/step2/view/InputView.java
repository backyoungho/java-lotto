package step2.view;

import step2.constants.Constants;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (price % Constants.LOTTO_PRICE != 0) {
            throw new RuntimeException(String.format("%s원 단위로 구입할 수 있습니다.", Constants.LOTTO_PRICE));
        }
        return price;
    }

    public static List<Number> inputPrizeLotto() {
        printNewLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] prizeNumbers = scanner.next().split(",");
        List<Number> prizeLotto = new ArrayList<>();
        for (String number : prizeNumbers) {
            prizeLotto.add(Number.from(Integer.valueOf(number)));
        }
        return prizeLotto;
    }

    private static void printNewLine() {
        System.out.println("");
    }
}
