//Time Complexity: O(n)
//Space Complexity: O(n) for array and stack
//Did it run on leetcode: yes
/** Approach: I used a stack to solve this problem
    Move from left to right of the given number and keep inserting if the elements are in increasing order
    else if top is greater than the current index keep popping until top is less than current index
    you need to pop the stack until k digits are removed following this process **/

class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())
            return "0";
        
        Stack<Integer> stack = new Stack<>();
        //stack.push(Character.getNumericValue(num.charAt(0)));
        int count = 0;
        
        for(int i=0; i<num.length(); i++){
            int curr = Character.getNumericValue(num.charAt(i));
            while(!stack.isEmpty() && stack.peek()>curr && count < k){
                stack.pop();
                count += 1;
            }
            stack.push(curr);
        }
        
        
        while(count<k){
                stack.pop();
                count += 1;
        }
        
        
        int[] arr = new int[stack.size()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = stack.pop();
        }
        
        //000200
        StringBuffer output = new StringBuffer();
        int flag = 0;
        for(int i=0; i<arr.length; i++ ){
            if(arr[i]==0 && flag==0)
                continue;
            else{
                flag = 1;
                output.append(arr[i]);
            }
        }
        
        if(flag == 0)
            return "0";
        
        return output.toString();
    }
}
