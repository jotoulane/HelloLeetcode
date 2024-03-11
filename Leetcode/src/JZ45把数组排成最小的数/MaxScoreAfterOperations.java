package JZ45把数组排成最小的数;
import java.util.HashMap;
import java.util.Map;

public class MaxScoreAfterOperations {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] dp = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            for (int num : count.keySet()) {
                int freq = count.get(num);
                for (int j = 0; j <= freq; j++) {
                    if (i >= j) {
                        dp[i] = Math.max(dp[i], dp[i - j] + Math.min(freq - j, j));
                    }
                }
            }
        }

        return dp[k];
    }

    public static void main(String[] args) {
        MaxScoreAfterOperations solution = new MaxScoreAfterOperations();
        int[] nums = {4,6, 1, 2};
        int k = 2;
        int result = solution.maxScore(nums, k);
        System.out.println("最大可能分数：" + result);
    }
}
