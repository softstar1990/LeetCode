public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int profit = 0;
        int cur_min = prices[0]; 
        
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - cur_min);
            cur_min = Math.min(cur_min, prices[i]);
        }
        
        return profit;
    }
}