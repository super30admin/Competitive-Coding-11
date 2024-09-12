Time Complexity  - O(n)
Space Complexity - O(n)
class Solution {
    public String removeKdigits(String nums, int k) {
        if(nums == null || nums.length() == 0 || k >= nums.length())
            return "0";
        if(k == 0)
            return nums;
        
        Stack<Character> stack = new Stack<>();
        // char[] n = nums.toCharArray();
        
        stack.push(nums.charAt(0));
        for(int i=1;i<nums.length(); i++){
            char ch = nums.charAt(i);
            while(!stack.isEmpty() && stack.peek() > ch && k >0){
                stack.pop();
                // stack.push(ch);
                k--;
            }
            stack.push(ch);
        }
         
        while(k>0){
            stack.pop();
            k--;            
        }
        
        StringBuilder sb = new StringBuilder();
        // String s = "";
        while(!stack.isEmpty()){
           sb.append(stack.pop());
            System.out.println(sb);
        }
        sb.reverse();
        int i=0;
        while(sb.length() > 1 && sb.charAt(i) == '0'){
            sb.deleteCharAt(i);   
        }
        
     return sb.toString();   
    }
}
