import java.util.*;

public class RemoveKDigits {

    //As we need to look for smallest element, we can use stack.
    //We can hold the items in the stack until we find the lesser number
    //If the incoming number is smaller replace the top. We need to repeat until k becomes zero.
    //else just push it to the stack.
    //Edge cases - If it is repeated numbers:
    //Then K remains same so remove any character.

    //Remove the prfix 0s
    //Check for the first index zero and remove it.

    //TC:O(N) Iterating the entir string only once.
    //SC:O(N) Using stack for performaing the calculation.
     public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) return num;
        
        if(num.length() == k) return "0";
        
        Stack<Character> stack = new Stack();
        for(int i=0;i<num.length();i++) {
            char currentChar = num.charAt(i);
            int currentNumber = Integer.valueOf(currentChar);
            while(!stack.isEmpty() && Integer.valueOf(stack.peek()) > currentNumber && k>0) {
                stack.pop();
                k--;
            }
            stack.push(currentChar);
        }
        
        if(stack.isEmpty()) return "0";
        //If it is 11111
        while(k>0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
