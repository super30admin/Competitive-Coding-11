

//Time Complexity: O(n)
//Space Complexity: O(n)

//We use a stack to keep track of the digits in the number. 
//We iterate through each digit in the number and compare it with the top of the stack.
//If the current digit is smaller than the top of the stack and we still have k digits to remove,
//we pop the top of the stack. This ensures that we are removing larger digits first to form a smaller number.
//After processing all digits, if we still have k digits to remove, we pop from the stack until k is zero. 
//Finally, we construct the result from the stack, remove any leading zeros, and return the result.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<num.length();i++){
            int c=num.charAt(i)-'0';
            while(!stk.isEmpty()&&stk.peek()>c&&k>0){
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        //if all the no are in inc all the ele will be in stack so we remove k ele from stack
        while(k>0 && !stk.isEmpty()){
            stk.pop();
            k--;
        }

        String ans="";
        while(!stk.isEmpty()){
            ans=Integer.toString(stk.pop())+ans;
        }
        
        //remove leading 0's
        int i=0;
        while(i<ans.length()&&ans.charAt(i)=='0'){
            i++;
        }
        ans=ans.substring(i);

        if(ans.equals(""))
            return "0";
        else 
            return ans;
    }
}