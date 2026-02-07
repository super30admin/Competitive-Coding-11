class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        Stack<Character> st = new Stack<>();
        int cnt = 0,ptr = 0;

        if(length == k) return new String("0");

        for(ptr = 0; ptr<length;ptr++){
            char ch = num.charAt(ptr);

            while(!st.isEmpty() && st.peek() > ch && cnt < k){
                char poppedEl = st.pop();
                System.out.println(poppedEl);
                cnt++;
                if(cnt == k) break;
            }

            if(st.size() == 0 && ch == '0') continue;
            st.push(ch);
        }

        if(cnt != k){
            while(!st.isEmpty() && cnt < k){
                cnt++;
                st.pop();
            }
        }

      
    char[] result = new char[st.size()];
    int idx = st.size()-1;

    while(!st.isEmpty()){
        result[idx--] = st.pop();
    }

    String ans = new String(result);
    return (ans.equals("")) ? "0" : ans; 
    }
}