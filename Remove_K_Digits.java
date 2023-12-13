// TC : O(n)
// SC : O(n)

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num == null || num.length() == 0 || k == 0) return num;
        
        Stack<Character> stack = new Stack<>();
        
        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.push(digit);
    }
        
    for(int i=0; i<k; ++i) {
      stack.pop();
    }
        
    StringBuilder ret = new StringBuilder();
    boolean leadingZero = true;
    for(char digit: stack) {
      if(leadingZero && digit == '0') continue;
      leadingZero = false;
      ret.append(digit);
    }
        
    if (ret.length() == 0) return "0";
    return ret.toString();
        
    }
}
