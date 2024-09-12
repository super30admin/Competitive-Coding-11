//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(k==n) return "0";
        Stack<Character> s = new Stack<>();
        for(char c : num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek()>c){
                s.pop();
                k--;
            }
            if(!s.isEmpty() || c!='0'){
                 s.push(c);
             }
        }
        while(k>0 && !s.isEmpty()){
            s.pop();
            k--;
        }
        StringBuilder sb= new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());   
        }
        sb.reverse();
        return sb.toString().length()>0 ? sb.toString() : "0" ;
    }
}