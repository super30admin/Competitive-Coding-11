 class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public String removeKdigits(String num, int k) {

        Stack <Character> s = new Stack<>();
       for (int i =0; i < num.length();i++){
         
            while (k> 0 && !s.isEmpty() && s.peek() > num.charAt(i)){
                s.pop();
                k--;
            }
            if (s.isEmpty() && num.charAt(i) == '0')
            continue;

            s.push(num.charAt(i));
       }
       while (k > 0 && !s.isEmpty()){
s.pop(); k--;

       }
       
    StringBuilder sb = new StringBuilder();
    //remove leading zeros
       while(!s.isEmpty())
        sb.append(s.pop());
           // stack to number; 
           return sb.length() != 0 ? sb.reverse().toString() : "0";
    }
}
