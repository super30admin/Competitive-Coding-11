class RemoveKDigits {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public String removeKdigits(String num, int k) {
        // edge case
        if(num == null || num.length() == 0 || k <= 0)
            return num;
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            
            if(!stack.isEmpty() || c != '0')
                stack.push(c);
        }
        
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        
        if(stack.isEmpty())
            return "0";
        
        // Iterate
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        // Reverse
        sb.reverse();
        
        return sb.toString();
    }
}