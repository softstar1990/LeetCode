public class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean flag = false;
        if(x<0){
            x = -x;
            flag = true;
        }
        while(x > 0){
            int ld = x % 10;
            result = result * 10 + ld;
            x /= 10;
        }
        return flag ? -result : result;
    }
}
