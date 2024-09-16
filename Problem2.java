// time - O(N)
// space - O(N)



class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stk = new LinkedList<>();

        for(char c: num.toCharArray()) { // iterate through the char array

            while(stk.size() > 0 && k > 0 && c < stk.peekLast()) {

                stk.removeLast();
                k = k - 1;

            }

            stk.addLast(c);

        }

        // remove remaining k elements from the stack from the tail
        for(int i = 0; i < k; i++) {
            stk.removeLast();
        }

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;

        for(char c: stk) { // remove the leading zero's

            if(leadingZero && c == '0') continue;
            leadingZero = false;
            result.append(c);
        }

        if(result.length() == 0) return "0";

        return result.toString();
    }
}