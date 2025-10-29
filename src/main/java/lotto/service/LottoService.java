package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoStore;
import lotto.util.InputValidator;

public class LottoService {
    private final LottoStore lottoStore = new LottoStore();
    private final InputValidator validator = new InputValidator();

    public void run() {
        int money = readPurchaseAmount();
        lottoStore.buyLottos(money);
        // 이후 당첨 번호 로직 등 추가 가능
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
}
