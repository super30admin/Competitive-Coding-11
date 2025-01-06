// Approach : From the intution of brute force where we need to form all combinations and find the minimum num. Exponential Time.
// So to eliminate few combinations we can take a greedy Approach of where the curr digit is less than left digit then we can land on highest number so we need
// to remove the left digit and continue like this until k=0.
// Time : O(n)
// Space : O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for(char digit: num.toCharArray()){    
            while(!stk.isEmpty() && k>0 && stk.peek()>digit){ // 3 2 2 1
                k--; // 0
                stk.pop();// remove the previous largest number - 4 3 2
            }
            stk.push(digit); // 1 2 1 9
        }
        // when num is strictly increasing - 12345
        // just remove last k digits from the stack
        for(int i =0;i<k;i++){
            stk.pop();
        }
        
        StringBuilder res = new StringBuilder(); 
        // go through what's left in the stack and build the res 
        boolean leadingZero = true;
        for(char digit:stk){
            if(leadingZero && digit == '0') continue; // don't add to result
            leadingZero = false;
            res.append(digit);
        }
        if(res.length() == 0) return "0";
        return res.toString();
    }
}