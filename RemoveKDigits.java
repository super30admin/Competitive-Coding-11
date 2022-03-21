//time complexity : O(N)
//space complexity: O(N) for the StringBuilder
//approach mentioned with in-line comments

class Solution {
    public String removeKdigits(String num, int k)
    {
        int curr = 0;
        int removed = 0;
        StringBuilder sb = new StringBuilder(num);

        //mark the numbers that are to be removed whenever
        // preceeding number is greater
        //we know if that number is greater
        // removing it will result in a smaller number overall
        while(removed < k && curr < sb.length() - 1){
            while(removed < k && curr >= 0 && curr < sb.length() - 1
                  && (int)sb.charAt(curr) > (int)sb.charAt(curr+1))
            {
                sb.deleteCharAt(curr--);
                removed++;
            }

            curr++;
        }

        String res = null;

        if(!sb.isEmpty()){
            int add = 0;
            int end = 0;

            //if we couldn't remove k from the beginning
            // we know it might be montonic increasing so
            // in that case we just remove from left over digits from the end
            while(removed < k){
                end++;
                removed++;
            }

            //we remove all preceeding zeroes
            while(add < sb.length() && sb.charAt(add) == '0'){
                add++;
            }

            //if all were zeroes then we have gone beyoond the length of the stirng
            // and meed to return 0 in that case
            if(add > sb.length() - end)
            {
                return "0";
            }

            //finally we form our string from add ie. index with all zeroes removed
            //at the beginning and end which is truncated if required
            res = sb.toString().substring(add,sb.length() - end);
        }
        return !res.isEmpty() && res != null ? res : "0";
    }
}
