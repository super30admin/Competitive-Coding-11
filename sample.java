Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//for a number, insert in stack. for operation, remove top 2 numbers perform operation and put result in stack
//return stack.top at end.
class Solution {
    //O(n) //O(n)
    public int evalRPN(String[] tokens) {
        //base

        Stack<String> st= new Stack<>();
        int a,b;

        for(String arr: tokens){ //O(n)
            if(arr.equals("+")){
                a=Integer.parseInt(st.pop());
                b=Integer.parseInt(st.pop());
                st.push(a+b +"");
            }
            else if(arr.equals("-")){
                a=Integer.parseInt(st.pop());
                b=Integer.parseInt(st.pop());
                st.push(b-a +"");
            }
            else if(arr.equals("*")){
                a=Integer.parseInt(st.pop());
                b=Integer.parseInt(st.pop());
                st.push(a*b +"");
            }
            else if(arr.equals("/")){
                a=Integer.parseInt(st.pop());
                b=Integer.parseInt(st.pop());
                st.push(b/a +"");
            }
            else{ //number
                st.push(arr);
            }
        }
        return Integer.parseInt(st.pop());
    }
}


Problem 2
// Time Complexity : O(4n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Numbers to the left matter most. start a for loop,put numbers in stack, if u find a number less than stack.top. pop until u find a smaller than current number. and then put current number.
// do this until u remove k elements or u are at the end of the array.
//if k is remaining at the end of array, remove remaining k elements from top of stack
// take num in stringbuilder, reverse it and remove trailing zeros. return the stringbuilder.
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(k==0) return num;
        if(n==k || n<k) return "0";
        Stack<Character> st= new Stack<>();

        for(char c: num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.add(c);
        }

        for(int i=0;i<k;i++){ //if k>0
            st.pop();
        }
        
        StringBuilder sb=new StringBuilder();

        while(!st.isEmpty()){
            // sb.insert(0,st.pop());
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}