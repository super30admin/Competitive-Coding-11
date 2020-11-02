class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        
        HashSet<String> hs = new HashSet<>();
        hs.add("+"); hs.add("-"); hs.add("*"); hs.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){ // time complexity will be O(n) and space also O(n)
            if(hs.contains(str) && stack.size() > 1 ){
                int top2 = stack.pop();
                int top1 = stack.pop();
                if(str.equals("+")){
                    stack.push(top1+top2);
                }else if(str.equals("-")){
                    stack.push(top1-top2);
                }else if(str.equals("*")){
                    stack.push(top1*top2);
                }else{
                    stack.push(top1/top2);
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.peek();
    }
}