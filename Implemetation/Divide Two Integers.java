 public class Solution {
    public int divide(int dividend, int divisor) {
      if (divisor==0){
           return 0;
        }
 
 // conver the diviedend and divisor to long before apply Math.abs()
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long result=0;
        
        while (a >= b){
            long c = b;
            int i = 0;
            while(c <= a){
                a -= c;
                c <<= 1;
                result += (1<<i);
                i++;
            }
            
        }
        if (dividend<0 && divisor>0 || dividend>0 && divisor<0){
            result=-result;
        }
        return (int)result;
    }
}