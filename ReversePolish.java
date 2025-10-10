class Solution {
    //Idea is to use stack to perform operation on last two numbers
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        for(String str:tokens)
        {
            if(str.equals("*")|| str.equals("+")||str.equals("/")|| str.equals("-"))
            {
                int second = stk.pop();
                int first = stk.pop();
                if(str.equals("*"))
                {
                    stk.push(first*second);
                }
                else if(str.equals("+"))
                {
                    stk.push(first+second);
                }
                else if(str.equals("/"))
                {
                    
                    stk.push(first/second);
                }
                else
                {
                    stk.push(first-second);
                }
            }
            else{
            //convert to number
             stk.push(Integer.valueOf(str));
            }
        }
        return stk.pop();
    }
}