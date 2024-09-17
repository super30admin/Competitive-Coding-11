/*
 * We try to maintain a monotonic stack. 
 * Then we try to solve the edge cases such as trailing zeros and increasing number.
 * 
 * TC = O(N)
 * SC = O(N)
 */

import java.util.*;
public class RemoveKDigits {
    
    public static String removeKDigits(String num, int k)
    {
        if(num == null || num.length() == 0) return "0";

        Stack<Integer> s = new Stack<>();
        int temp = k;

        for(int i =0;i<num.length();i++)
        {
            while(!s.isEmpty() && temp!=0 && Integer.parseInt(String.valueOf(num.charAt(i)))<s.peek())
            {
                s.pop();
                temp--;
            }

            s.push(Integer.parseInt(String.valueOf(num.charAt(i))));
        }

        if(temp>0)
        {
            while(temp>0)
            {
                s.pop();
                temp--;
            }
        }

        StringBuilder sb  = new StringBuilder();
        while(s.size()>0)
        {
            sb.append(s.pop());
        }

        sb=sb.reverse();
        int count = 0;
        for(int i =0;i<sb.length()-1;i++)
        {
            if(sb.charAt(i)=='0')
            {
                count++;
            }
            else{
                break;
            }
        }
        return sb.substring(count,sb.length());
    }

    public static void main(String args[])
    {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKDigits(num, k));
    }
}
