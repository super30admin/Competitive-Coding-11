//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> s1 = new Stack<>();
        
        int count = 0;
        
        String result = "";
        //int index = 0;
        
        for(int i = 0; i < num.length(); i ++){
            
            char ch = num.charAt(i);
           
            
            if(!s1.isEmpty() && count != k){
                
               // index ++;
                if(Character.getNumericValue(ch) >= s1.peek() ){
                    
                    s1.push(Character.getNumericValue(ch));
                }
                
                else{
                    while(!s1.isEmpty() && Character.getNumericValue(ch) < s1.peek() && count != k){
                        
                    count ++;
                    s1.pop();
                   
                    }
                     s1.push(Character.getNumericValue(ch));
                  
                }
            }
            
        
            
            else {
                
               
                
                s1.push(Character.getNumericValue(ch));
            }
            
         
        }
         //System.out.println(s1);
        
        while(count != k){
            
            count ++;
            s1.pop();
        }
            while(!s1.isEmpty()){
                
                result = String.valueOf(s1.pop()) + result;
            }
        while(result.length() > 1 && result.charAt(0) == '0'){
            
            result = result.substring(1);
        } 
        
        if(result == ""){
            
            return "0";
        }
         
                 return result;
    }
}