//Time complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        //use stack to keep track of the characters with the least value(ascending order)
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            //if the top of the stack is greater than the current element then it should be popped as a lesser value compared to it is found
            while(!stack.isEmpty() && stack.peek()>c && k>0){
                stack.pop();
                //decrement the k as well
                k--;
            }
            //if any leading zero's are found it should be ignored
            if(!stack.isEmpty() || c!='0'){
                stack.push(c);
            }
        }
        //if all the numbers in the input are already in ascending order, then the numbers from the right most must be removed Ex:123 and k=2 so first 3 is removed follwed by 2
        while(!stack.isEmpty()&&k>0){
            stack.pop();
            k--;
        }
        //if the length of i/p string and k are equal there everything is removed, hence return 0
        if(stack.isEmpty()){
            return "0";
        }
        //after iterating through the string, the stack will have the final result
         StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        //reverse it as it is stored in the stack
        str.reverse();
        return str.toString();
    }
}