// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> st = new Stack<>(); // to process the string numbers
        
        for(int i=0;i<tokens.length;i++) // iterate over the string
        {
            String s = tokens[i]; // get the string
            
            if(!"+-*/".contains(s)) // check if it is a number
            {
                st.push(Integer.valueOf(s)); // push number to stack
               
            }
            else // if operation
            {
                int num1 = st.pop(); // pop out two numbers on which the operation has to be done
                int num2 = st.pop();
                
                if(s.equals("+")) // perform the operation and push the result to stack
                {
                    int res = num1 + num2;
                    st.push(res); 
                }
              else if(s.equals("-"))
                {
                    int res = num2 - num1;
                     st.push(res); 
                }
                else if(s.equals("*"))
                {
                    int res = num2 * num1;
                     st.push(res); 
                }
                else if(s.equals("/"))
               {
                    int res = num2 / num1;
                     st.push(res); 
                }
                
            }
        }
        
        return st.pop();
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Integer> st = new Stack<>(); // to keep numbers
        st.push(num.charAt(0)-'0'); // push first number which is prev
        StringBuilder str = new StringBuilder(); // to form result
        for(int i=1; i<num.length();i++) //iterate over string num
        {
            int curr = num.charAt(i)-'0'; // get curr number
            
            while(k>0 && (!st.isEmpty() && curr<st.peek())) // check if elements have to be removed from num (k>0) and value at curr< prev
            {
                st.pop(); // pop the prev value out
                k--; // reduce k
            }
            
            st.push(curr); // push each element to stack
        }
        
        while(k!=0) // if k is not zero
        {
            st.pop(); // pop elements out of stack ( when numbers are ascending)
            k--;
        }
        
        while(!st.isEmpty()) // make the result
        {
            str.append(st.pop());
        }
        
        str.reverse(); // reverse it
        
       int i=0; 
        
      while(i<str.length() && str.charAt(i) - '0' == 0) // mark i where leading zeros end
       {
              i++;
       }
        
        
        return  str.substring(i,str.length()).length() == 0 ? "0" : str.substring(i,str.length()).toString(); // if empty string return "0" else remove leading zeros and retrun string result
        
    }
}