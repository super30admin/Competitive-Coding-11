//Time Complexity: O(n * log(sumOfWeights - maxElement))
//Space Complexity: O(1)

public class CapacityOfShip {
	public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0) return 0;
        int sumOfWeights = 0;
        int low = 0;
        for(int w: weights){
            low = Math.max(low, w);
            sumOfWeights += w;
        }
        int high = sumOfWeights;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int currDays = 1; int currSum = 0;
            for(int i = 0; i < weights.length; i++){
                if(currSum + weights[i] > mid){
                    currDays++;
                    currSum = 0;
                }
                currSum += weights[i];
            }
            if(currDays > D){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
