/*
Time complexity is O(n)
Space complexity is O(n)
Using stacks

*/
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> input = new Stack<Integer>();
        int result;

        for(String x : tokens){
            if( x.length() > 1 || Character.isDigit(x.charAt(0))){
                input.push(Integer.parseInt(x)); 
            } else{
                System.out.println(input);
                    int rSide = input.pop();
                    int lSide =input.pop();

                System.out.println(input);

            switch(x){                 
                case "+":                    
                    input.push(lSide+rSide);  
                    break;                     
                case "-":                 
                    input.push(lSide-rSide);
                    break;                
                case "*":                     
                    input.push(lSide*rSide);
                    break;                
                case "/":                     
                    input.push(lSide/rSide);
                    break;                
                }  
            }
        }
        return input.pop();
    }
}