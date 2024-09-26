// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String nums, int k) {
        if(nums.length()==1 && k>0) return "0";
        if(k==0) return nums;
        if(k==nums.length()) return "0";
        Stack<Character> stack =  new Stack<>();
        StringBuilder str = new StringBuilder("");
        stack.push(nums.charAt(0));
        for(int i = 1;i<nums.length();i++){
            if(!stack.isEmpty() && (nums.charAt(i)-'0')>=(stack.peek()-'0')){


                    int c = (nums.charAt(i) - '0');
                    int m = (stack.peek() - '0');
                    stack.push(nums.charAt(i));

            }
            else{
                while(!stack.isEmpty() && k>0){
                    if(stack.peek()>nums.charAt(i)){
                        stack.pop();
                        k--;
                    }
                    else{
                        break;
                    }
                }
                stack.push(nums.charAt(i));
            }
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        str.reverse();
        while(str.length()>1 && str.charAt(0)=='0'){
            str.deleteCharAt(0);
            }
        return str.toString();
    }
}