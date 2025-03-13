/*
TC : O(N)
SC : O(1)
 * 
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.empty() || prices.size()==0){
            return 0;
        }

        int Profit = 0;
        int curStock = prices[0];

        for(int i=0;i<prices.size();i++){
            int curProfit = 0;
            if(prices[i]>=curStock){
                curProfit = prices[i] - curStock;
            }

            if(curProfit>0){
                Profit += curProfit;
            }
            curStock = prices[i];
        }

        return Profit;
    }
};