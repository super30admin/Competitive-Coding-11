//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> s1 = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        //String s = Arrays.toString(tokens);
         //System.out.println(tokens[0]);
       // char[] charArray = tokens.toCharArray();
       // int num = 0;
       // boolean flag = false;
        for(int i = 0; i < tokens.length ; i ++){
            
          //  char ch = s.charAt(i);
          //  System.out.println(s1);
        if(set.contains(tokens[i])){
            
            int temp1 = s1.pop();
            int temp2 = s1.pop();
            
             if(tokens[i].equals("+")){
             
             s1.push(temp2+temp1);
         }
            
             else if(tokens[i].equals("-")){
             
         
             s1.push(temp2-temp1);
         }
            
             else if(tokens[i].equals("*")){
             
          
             s1.push(temp2*temp1);
         }
             else if(tokens[i].equals("/")){
             
             s1.push( temp2 / temp1);
         }
            
            
        }
        
            else{
                
                s1.push(Integer.parseInt(tokens[i]));
            }
        }
        return s1.pop();
    }
}