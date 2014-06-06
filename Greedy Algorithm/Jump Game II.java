public class Solution {
    public int jump(int[] A) {
        if(A==null||A.length==0||A.length==1){
            return 0;
        }
        int start = 0;
        int end   = 0;
        int jump_times = 0;
        int max   = 0;  
        while(end<A.length) {
            max = 0;
            jump_times++;
            //find the max index we can jump to from current closure
            for(int i=start;i<=end;i++) {
                if((A[i]+i)>=(A.length-1)) {
                    return jump_times;
                }
                if((A[i]+i)>max) {
                    max = A[i]+i;
                }
            }
            //update next closure
            start = end + 1;
            end   = max;
        }
        return jump_times;
    }
}