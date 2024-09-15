// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {

        if(tokens == null || tokens.length == 0){
            return 0;
        }

        if(tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> s = new Stack<>();
        int output = 0;

        for(String str:tokens){

            //add the top elements
            if(str.equals("+")){
                int val = s.pop() + s.pop();
                s.push(val);
                output = val;
            }
            //subtract the top elements
            else if(str.equals("-")){
                int val = (s.pop()-s.pop())*-1;
                s.push(val);
                output = val;
            }
            //multiply the top elements
            else if(str.equals("*")){
                int val = s.pop() * s.pop();
                s.push(val);
                output = val;
            }
            //divide the top elements
            else if(str.equals("/")){
                int val1 = s.pop();
                int val2 = s.pop();
                s.push(val2/val1);
                output = val2/val1;
            }
            //numeric
            else{
                s.push(Integer.parseInt(str));
            }
        }

        return output;

    }
}