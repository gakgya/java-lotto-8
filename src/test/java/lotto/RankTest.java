package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    void 랭크_매칭_테스트() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE);
    }
}
