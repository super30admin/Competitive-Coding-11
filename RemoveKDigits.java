public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        for(int i=1;i<num.length();i++){
            // Edge case 1: Checking if stack is empty and k>0
            while(!st.isEmpty()&&k>0&&st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        // Edge case 2: If all values where were pushed into stack without any pops
        for(int i=0;i<k;i++){
            st.pop();
        }
        
        StringBuilder temp = new StringBuilder();
        while(!st.isEmpty()){
            temp.append(st.pop());
        }
        
        StringBuilder result = new StringBuilder();
        result=temp.reverse();
        
        // Edge case 3: Removing any leading zeroes
        int a = 0;
        for(int i=0;i<result.length();i++){
            if(result.charAt(i) == '0')
                a++;
            else break;
        }
        
        result.delete(0,a);
        if(result.length()==0)
            return "0";
        else return result.toString();
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
