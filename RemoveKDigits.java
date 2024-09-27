//Time Complexity: O(n)
//Space Complexity: O(n)
public class RemoveKDigits {
    public String removeKdigits(String num, int k) 
    {
        if(num == null || num.length() == k)
            return "0";
        
        Stack<Character> st = new Stack<>();
        
        for(char c : num.toCharArray())
        {
            while(!st.isEmpty() && c < st.peek() && k > 0)
            {
                st.pop();
                k--;
            }
            st.push(c);  
        }
        
        while(k > 0)
        {
            st.pop();
            k--;
        }
        
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        ans = ans.reverse();
        
        while(ans.length() > 1 && ans.charAt(0) == '0')
        {
           ans.deleteCharAt(0); 
        }
       
        return ans.toString();
    }
}
