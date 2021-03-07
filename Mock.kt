package S30Mocks

import java.lang.StringBuilder
import java.util.*


    fun removeKDigtis(num: String, k: Int):String{
        var count = k
        var st = Stack<Char>()
        for (c in num) {

            while(!st.isEmpty() && count > 0 && st.peek()> c){
                st.pop()
                count--

            }
            if (!st.isEmpty() || c!= '0'){
                st.push(c)
            }

        }
        //12345
        while(!st.isEmpty() && count > 0){
            st.pop()
            count--
        }
        if (st.isEmpty()){
            return "0"
        }

        var sb = StringBuilder()
        while(!st.isEmpty() && count == 0){
            sb.insert(0,st.pop())
        }

        return sb.toString()
    }



fun main(){

    print(removeKDigtis("20",2))

}