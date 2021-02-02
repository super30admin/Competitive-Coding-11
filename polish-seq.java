// Time, Space - O(N), O(N)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> s = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+")) {
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v1 + v2);
            }
            else if(token.equals("-")) {
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v2 - v1);
            }
            else if(token.equals("*")) {
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v2 * v1);
            }
            else if(token.equals("/")) {
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v2/v1);
            }
            else {
                s.push(Integer.parseInt(token));
            }
        }
        
        return s.pop();
    }
}
