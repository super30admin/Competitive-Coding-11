//Problem 146: Remove K Digits
//TC:O(n)
//SC: O(n)

/*
  Basically the smallest combination will be when the number is in ascending order
  Bruteforce: TC:Exponential -> Create subset of n-k size and then find which number is smallest
  Optimized: 1) TC: O(nk) -> Traverse over the array from left and whenever previous element is greater than the current element , just remove the greater one and again start from 0th index until k==0;  
             2) Using Stack, as ascending order history matters so stack is the best data structure.
                ->Traverse over the array and keep pushing the number in the stack. If at any point incoming number is smaller than the peek element, just remove the peek element until peek elements becomes lesser than the incoming elements and k>0
                -> There can be a case when all elements are in ascending order and k remains greater than the zero, for that case just pop the peek elements from the stack until k>0
                ->There could be a case when there will be leading zeroes, for that case create a int array, add all stack elements starting from last to that array and then iterate over that array for removing the leading zeroes.
                
           //For interview, u can ask interviewer to use LinkedList instead of stack , so that removal of leading zeroes can happen easily, because then u can iterate from starting of the linkedlist for find the leading zeroes. Along with that u can use LinkedList functions such as peekLast() or removeLast() or addLast(). This can save extra space for the int array     
                

*/

import java.util.*;
class Solution146 {
    public String removeKdigits(String num, int k) {
        
        if(num==null || num.length()==0) return "";
        
        //TC:O(n)+O(k)+(n-k)=>O(n) || SC:O(n)
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<num.length();i++){
        
           char ch = num.charAt(i); 
           int n =   ch - '0'; 
            
           while(!stack.isEmpty() && stack.peek()>n && k>0){
               stack.pop();
               k--;
           }
            stack.push(n);
        }
        
        //if num was in ascending order, then k digits to be removed from the last, i.e right side or say peek of the stack
        //TC:O(k)
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        
         //SC:O(n-k)
         //For handling leading zeroes case
        int[] res = new int[stack.size()];
        int i = stack.size()-1;
        
         //TC:O(n-k)
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        
         //TC:O(n-k) || SC:O(n-k)
        StringBuilder sb = new StringBuilder();
        boolean leadingZeroes = true;
        for(int n:res){
            if(leadingZeroes && n==0) continue;
            leadingZeroes = false;
            
            sb.append(n);
        }
        
         //TC:O(n-k)
        return sb.length()==0 ?"0" : sb.toString();
    }
}