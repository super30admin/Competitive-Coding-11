class Solution {
    public String removeKdigits(String num, int k) {
        
       //base case
        if(num == null || num.length() == 0 || num.length() == k){
            return "0";
        }
      
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder(""); 
        
        for(int i = 0; i < num.length(); i++){
            int n = num.charAt(i) - '0';
            
            if(stack.isEmpty()){
                stack.push(n);
            }else{
                if(stack.peek() <= n){
                    stack.push(n);
                }else{
                    while(!stack.isEmpty() && stack.peek() > n && k > 0){
                        stack.pop();
                        k--;
                    }
                    
                    if(!stack.isEmpty() ||n!=0){
                        stack.push(n);
                    } 
                }
            }
            
        }
        
        //popping elements until k = 0
        if(k > 0){
            while(k > 0 && !stack.isEmpty()){
                stack.pop();
                k--;
            }
        }
        
        if(stack.isEmpty()) {
            return "0";
        }
        
        //handling leading 0's
        for(int n: stack) 
            if(n == 0 && sb.length() == 0) continue;
            else sb.append(n);
        
        return sb.length() == 0 ? "0": sb.toString();
        
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)