class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for(String str : tokens){
            if(str.equals("+")){
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num1+num2);
            }else if(str.equals("-")){
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num2-num1);
            }else if(str.equals("*")){
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num1*num2);

            }else if(str.equals("/")){
                int num1 = s.pop();
                int num2 = s.pop();
                s.push(num2/num1);
            }else{
                s.push(Integer.parseInt(str));
            }
        }
    return s.pop();
    }
}