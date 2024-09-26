class Solution {
    public String removeKdigits(String num, int k) {
        String s = ""; 
        if(num.length() <= k)
            return "0";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            if(k==0 || st.isEmpty() || st.peek()<=num.charAt(i)){
                st.push(num.charAt(i));
            }
            else{
                char curr = num.charAt(i);
                if(st.peek()>curr){
                    while(!st.isEmpty() && k>0 && st.peek() > curr){
                        st.pop();
                        k--;
                    }
                    st.push(curr);
                }
            }
        }
        while(k>0){
            st.pop();
            k--;
        }
        int count = 0;
        while(!st.isEmpty()){
            if(st.peek()=='0')
                count++;
            else
                count=0;
            s = st.pop()+s;
        }
        String res = s.substring(count);
        if(res.equals("")) return "0";
        return res;
    }
}


//if incoming element is larger than current them push that into stack until you find a smaller element
//if incoming element is smaller than current then pop current

//Time complexity : O(N)
//Space complexity : O(N)
