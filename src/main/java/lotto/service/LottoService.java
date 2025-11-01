package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.util.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoStore lottoStore = new LottoStore();
    private final InputValidator validator = new InputValidator();

    public void run() {
        int money = readPurchaseAmount();
        List<Lotto> lottos = lottoStore.buyLottos(money);
        LottoResult result = runWinningProcess(lottos);
        result.printStatistics();
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int money = validator.parseInteger(input);
                validator.validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoResult runWinningProcess(List<Lotto> lottos) {
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(",")).map(String::trim).map(validator::parseInteger).collect(Collectors.toList());
                validator.validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonus = validator.parseInteger(input);
                validator.validateBonusNumber(bonus, winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
