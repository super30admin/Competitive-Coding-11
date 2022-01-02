class Solution {
    public int maxProfit(int[] prices) {
        int min;
        min = prices[0];

        int profit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < prices[i-1]){
                profit += prices[i-1] - min;
                min = prices[i];
            }
            else{
                min = Math.min(min, prices[i]);
            }
        }
        return profit+(min==prices[prices.length-1]?0:prices[prices.length - 1]-min);
        // System.out.println(min);
        // return profit;
    }
}