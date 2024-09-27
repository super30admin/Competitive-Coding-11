// Time Complexity : O(N * D) 'N' is the input and 'D' is the average no. of digits in each no.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create the hashmap of each digit rotations which are given
// Now iterate for 1 to n. calculate its rotations
// If rotated digit is equal to original or no. can't be rotated
// We would skip otherwise we will increment the count, and finally return the count
class Solution {
    public int rotatedDigits(int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,0);
        hm.put(1,1);
        hm.put(8,8);
        hm.put(2,5);
        hm.put(5,2);
        hm.put(6,9);
        hm.put(9,6);
        int count = 0;
        for(int i = 1; i <= n; i++){
            int num = i;
            int newVal = 0;
            int numDigits = 1;
            boolean cantRotate = false;
            while(num != 0){ //21
                int x = num % 10; //1, 2
                num /= 10; //2, 0
                int y;
                if(hm.containsKey(x)){
                    y = hm.get(x); //1 , 5
                    newVal += numDigits * y; //1 + 10* 5 = 51
                   
                    numDigits = numDigits * 10; //10,100
                }
                else{
                    cantRotate = true;
                    break;
                }
            }
            if(cantRotate)
                continue;
            if(i != newVal){
                count++;
            } 
        }
        return count;
    }
}