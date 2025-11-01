package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    void 일치하는_번호_개수에_따라_랭크가_결정된다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))
        );

        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        LottoResult result = new LottoResult(lottos, winning, bonus);

        // 첫 번째 로또 → 1등
        // 두 번째 로또 → 3개 일치 → 5등
        // 세 번째 로또 → 2개 일치 → NONE

        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(Rank.NONE)).isEqualTo(1);
    }

    @Test
    void 보너스번호_일치시_2등_처리() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        LottoResult result = new LottoResult(lottos, winning, bonus);
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(1);
    }
}
