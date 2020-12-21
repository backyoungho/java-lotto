package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static LottoNumber scanBonusRepeat(Set<LottoNumber> winningNumbers) {
        while(true) {
            LottoNumber bonus = scanBonus();
            if (validBonusNumber(winningNumbers, bonus)) {
                return bonus;
            }
            System.out.println("당첨 번호와 보너스 볼의 번호가 중복됩니다. 다시 입력해주세요.");
        }
    }

    private static boolean validBonusNumber(Set<LottoNumber> winningNumbers, LottoNumber bonus) {
        return !winningNumbers.contains(bonus);
    }

    private static LottoNumber scanBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        return new LottoNumber(Integer.parseInt(input));
    }

    public static Set<LottoNumber> scanWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        return Arrays.stream(input.split(","))
                .map(Integer::new)
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}