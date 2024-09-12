//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        
        Stack<Integer> s =new Stack<>();
        for(String token:tokens){
            if(!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))){
                s.push((Integer.valueOf(token)));
            }
            else{
                int a = s.pop();
                int b=s.pop();
                int res=0;
                if(token.equals("+")) s.push(b+a);
                else if(token.equals("-")) s.push(b-a);
                else if(token.equals("*")) s.push(b*a);
                else if(token.equals("/")) s.push(b/a);
            }
        }
        return s.pop();
    }
}