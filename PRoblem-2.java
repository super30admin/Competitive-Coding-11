//TC: O(n)
//SC: O(n)

class Solution {
    public String removeKdigits(String num, int k) {
      
      if(num == null || num.length() == 0 || num.length() == k)
      {
          return "0";
      }
      
      
      Stack<Character> stack = new Stack<>();
      
      
      
      for(int i=0;i<num.length();i++)
      {
        char ch = num.charAt(i);
        
        while(k>0 && !stack.isEmpty() && stack.peek() > ch)
        {
          stack.pop();
          k--;
        }
        stack.push(ch);
          
      }
      
      while(k>0)
      {
        stack.pop();
        k--;
      }
     StringBuilder sb = new StringBuilder();

        // form the output string
        while(!stack.isEmpty()){
            char ch = stack.pop();
            sb.append(ch);
        }

        sb.reverse();

        //remove preceding zeroes
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}