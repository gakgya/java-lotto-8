package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new HashMap<>();
    private final double profitRate;

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningNumbers, bonusNumber);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        profitRate = calculateProfitRate(lottos.size());
    }

    private Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    private double calculateProfitRate(int ticketCount) {
        int totalReward = 0;
        for (Rank rank : resultMap.keySet()) {
            totalReward += rank.getReward() * resultMap.get(rank);
        }
        return (double) totalReward / (ticketCount * 1000) * 100;
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank.getMessage() + " - " + resultMap.get(rank) + "개");
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public int getCount(Rank rank) {
    return resultMap.get(rank);
}
}
