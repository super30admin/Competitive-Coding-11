// Time, space - O(N), O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num == null) {
            return "0";
        }
        
        if(k == num.length()) {
            return "0";
        }
        
        Stack<Character> s = new Stack<>();
        
        for(int i=0;i<num.length();i++) {
            char digit = num.charAt(i);
            
            while(s.size() > 0 && k > 0 && s.peek() > digit) {
                s.pop();
                k--;
            }
            
            s.push(digit);
        }
        
        
        for(int i=0; i<k; ++i) {
            if(!s.isEmpty())
                s.pop();
        }
        boolean leadingZero = true;
        
        StringBuilder res = new StringBuilder();
        for(char d : s) {
            if(leadingZero && d == '0') {
                continue;
            }
            leadingZero = false;
            res.append(d);
        }
        if(res.length() == 0) {
            res.append("0");
        }
        
        return res.toString();
    }
}
