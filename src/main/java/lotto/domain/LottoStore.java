package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public List<Lotto> buyLottos(int money) {
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
