// Time Complexity : O(n)
// Space Complexity : O(n) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String removeKdigits(String num, int k) {
        if(num==null||num.length()==0||k>num.length()){
            return "";
        }
        Stack<Character> res=new Stack<>();
        for(int i=0;i<num.length();i++){
           while(!res.isEmpty() && k>0 && res.peek()>num.charAt(i)){
               res.pop();
               k--;
           }
          
            res.push(num.charAt(i));
        
        }
         while(k>0){
                res.pop();
                k--;
            }
        StringBuilder result=new StringBuilder();
        while(!res.isEmpty()){
            result.append(res.pop());
        }
        int index=result.length()-1;
        while(index>=0&&result.charAt(index)=='0'){
            result.deleteCharAt(index);
            index--;
        }
        
        return result.length()==0 ? "0": result.reverse().toString();
    }
}