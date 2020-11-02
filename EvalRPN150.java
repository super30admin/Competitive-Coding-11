class Solution {
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        HashSet<String> set = new HashSet<>(4);
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        int first, second, temp = 0;
        for(int i = 0; i < tokens.length; i++){
            if(!set.contains(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }

            second = stack.pop();
            first = stack.pop();
            
            switch(tokens[i]){
                case "+" : 
                    temp = first + second;
                    break;
                case "-" :
                    temp = first - second;
                    break;
                case "*" :
                    temp = first * second;
                    break;
                case "/" :
                    temp = first / second;
                    break;
            }
            stack.push(temp);
        }
        return stack.pop();
    }
}