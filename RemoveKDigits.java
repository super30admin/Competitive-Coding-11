//TC : O(2n + K)

//SC : O(n) // using stack to store integers

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i< num.length(); i++){
            int n = Character.getNumericValue( num.charAt(i) );  
            while(!stack.isEmpty() && k > 0 && stack.peek() > n){ // if curr number is less then top of the stack
                k--; 
                stack.pop(); // pop an element
            }
            stack.push(n); // Push curr in stack then   
        }
        
        
        while(k-- > 0){ // Removing digits if k != 0 YET
            stack.pop();   
        }
        
        System.out.println(stack);
        StringBuilder res = new StringBuilder();
        
        
        while(!stack.isEmpty()){
            int c = stack.pop();
            
            res.append( (char)(c + '0') );
        }
        res.reverse();
        System.out.println(res);

        
        //Removing leading zeros
        int count = 0;
        for(int i = 0; i< res.length(); i++){
            if(res.charAt(i) == '0')
                count++;
            else{
                break;
            }
        }
        
        res.replace(0, count, "");
        System.out.println(res);
        
        if(!res.isEmpty())
            return res.toString();
        
        return "0";
    }
}