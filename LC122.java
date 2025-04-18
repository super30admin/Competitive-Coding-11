// TC: O(n)
// SC: O(1)
// where n is the number of prices

public class LC122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for(int i=1;i<n;i++){
            ans += Math.max(0, prices[i]-prices[i-1]);
        }
        return ans;
    }
}
