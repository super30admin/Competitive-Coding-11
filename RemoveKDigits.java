class Solution {
    
    // Obs1:
        // - Increasing num - 123456789 ==> 12345678, 112 ==> 11
        // - Decreasing Num - 987654321 ==> 87654321, 211 ==> 11
        // - num.length() == k ==> 0
    
    // Obs2: since anytime only one letter is compared or appended,
            // can use Stack of chars or charArray directly
    
    // Time Complexity:    O(n)
    // Space Complexity:   O(n)
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char currDigit;
        
        for(int i = 0; i < num.length(); i++){
            currDigit = num.charAt(i);

            // Pop out K numbers from stack that are lessthan the curr number
            while(!stack.isEmpty() && k > 0 && currDigit < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(currDigit);
        }
        
        // num = 15234, k = 2 ==> 1234 && k becomes 1
        while(!stack.isEmpty() && k > 0){   //  ==> 123
            k--;
            stack.pop();
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        res.reverse();

        // String withoutZeros = (res.toString()).replaceAll("^0+", "");
        while (res.length() > 1 && res.charAt(0) == '0') {
			res.deleteCharAt(0);
		}

        if(res.toString().equals(""))
            return "0";
        return  res.toString();   // "0200" ==> 200
    }
}